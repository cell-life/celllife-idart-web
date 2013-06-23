package org.celllife.idart.application.doctor;

import org.celllife.idart.application.ClinicNotFoundException;
import org.celllife.idart.application.code.DoctorCodeApplicationService;
import org.celllife.idart.domain.assignment.Assignment;
import org.celllife.idart.domain.assignment.AssignmentRepository;
import org.celllife.idart.domain.doctor.Doctor;
import org.celllife.idart.domain.doctor.DoctorIdentifierType;
import org.celllife.idart.domain.doctor.DoctorRepository;
import org.celllife.idart.domain.doctor.DoctorService;
import org.celllife.idart.domain.clinic.Clinic;
import org.celllife.idart.domain.clinic.ClinicRepository;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-29
 * Time: 12h16
 */
@Service("doctorApplicationService")
public final class DoctorApplicationServiceImpl implements DoctorApplicationService {

    @Autowired
    private ClinicRepository clinicRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorCodeApplicationService doctorCodeApplicationService;

    @Autowired
    private DoctorProvider prehmisDoctorProvider;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public List<Doctor> findByClinicIdentifier(String applicationId,
                                               String clinicIdentifierValue) {

        Clinic clinic = clinicRepository.findOneByIdentifier("http://www.cell-life.org/idart/facility", clinicIdentifierValue);

        if (clinic == null) {
            throw new ClinicNotFoundException("Clinic not found for identifier value: " + clinicIdentifierValue);
        }

        lookupAndSyncWithExternalProviders(clinic);

        return findAllDoctorsAssignedToClinic(clinic);
    }

    private List<Doctor> findAllDoctorsAssignedToClinic(Clinic clinic) {

        List<Doctor> doctors = new ArrayList<>();

        for (Assignment assignment : assignmentRepository.findByClinicId(clinic.getPk())) {
            doctors.add(assignment.getDoctor());
        }

        return doctors;
    }

    private void lookupAndSyncWithExternalProviders(Clinic clinic) {

        for (String identifierSystem : clinic.getIdentifierSystems()) {
            switch (identifierSystem) {

                case "http://prehmis.capetown.gov.za":
                    String clinicIdentifierValue = clinic.getIdentifierValue(identifierSystem);
                    Set<Doctor> prehmisDoctors = prehmisDoctorProvider.findAll(clinicIdentifierValue);
                    Set<Doctor> savedDoctors = saveDoctors(prehmisDoctors);
                    assignDoctorsToClinic(savedDoctors, clinic);
                    break;

                default:
                    break;
            }
        }
    }

    private void assignDoctorsToClinic(Set<Doctor> doctors, Clinic clinic) {

        for (Doctor doctor : doctors) {

            Assignment assignment = assignmentRepository.findOneByDoctorIdAndClinicId(doctor.getPk(), clinic.getPk());
            if (assignment == null) {
                assignmentRepository.save(new Assignment(doctor, clinic));
            }
        }
    }

    public Set<Doctor> saveDoctors(Iterable<Doctor> doctors) {

        Set<Doctor> savedDoctors = new HashSet<>();

        for (Doctor newDoctor : doctors) {

            Doctor existingDoctor = doctorService.findByIdentifiers(newDoctor.getIdentifiers());
            if (existingDoctor != null) {

                mapper.map(newDoctor, existingDoctor);
                savedDoctors.add(doctorRepository.save(existingDoctor));
            } else {

                newDoctor.addIdentifier(DoctorIdentifierType.IDART, doctorCodeApplicationService.nextDoctorCode());
                savedDoctors.add(doctorRepository.save(newDoctor));
            }
        }

        return savedDoctors;
    }
}
