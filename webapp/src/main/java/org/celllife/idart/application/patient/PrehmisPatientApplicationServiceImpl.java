package org.celllife.idart.application.patient;

import org.celllife.idart.application.code.PatientCodeApplicationService;
import org.celllife.idart.domain.patient.Patient;
import org.celllife.idart.domain.patient.PatientRepository;
import org.celllife.idart.domain.patient.PatientService;
import org.celllife.idart.domain.person.PersonRepository;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 11h36
 */
@Service("prehmisPatientApplicationService")
public final class PrehmisPatientApplicationServiceImpl implements PrehmisPatientApplicationService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientProvider prehmisPatientProvider;

    @Autowired
    private PatientCodeApplicationService patientCodeApplicationService;

    @Autowired
    private Mapper mapper;

    public void lookupAndSynchronise(String patientIdentifierValue, String clinicIdentifierValue) {
        savePatients(prehmisPatientProvider.findByIdentifier(clinicIdentifierValue, patientIdentifierValue));
    }

    public void savePatients(Iterable<Patient> patients) {

        for (Patient newPatient : patients) {

            personRepository.save(newPatient.getPerson());

            if (!newPatient.hasIdentifierForSystem("http://www.cell-life.org/idart/patient")) {
                String patientIdentifierValue = patientCodeApplicationService.nextPatientIdentifierValue();
                String patientIdentifierSystem = "http://www.cell-life.org/idart/patient";
                newPatient.addIdentifier(patientIdentifierSystem, patientIdentifierValue);
            }

            patientService.save(newPatient);
        }
    }


}
