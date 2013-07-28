package org.celllife.idart.domain.clinicpatient

import org.celllife.idart.domain.clinic.Clinic
import org.celllife.idart.domain.patient.Patient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 * Generated by org.celllife.idart.codegen.CodeGenerator
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class ClinicPatientServiceImpl implements ClinicPatientService {

    @Autowired ClinicPatientRepository clinicPatientRepository

    @Override
    boolean exists(Clinic clinic, Patient patient, Date dateActive) {
        clinicPatientRepository.countByClinicAndPatientAndDateActive(clinic, patient, dateActive) == 0
    }

    @Override
    void save(Clinic clinic, Patient patient) {

        def dateActive = new Date()

        if (exists(clinic, patient, dateActive)) {
            clinicPatientRepository
                    .save(new ClinicPatient(clinic: clinic, patient: patient, fromDate: dateActive))
        }
    }


    @Override
    void save(Clinic clinic, Iterable<Patient> patients) {
        patients.each { patient -> save(clinic, patient) }
    }

    @Override
    void save(Patient patient, Iterable<Clinic> clinics) {
        clinics.each { clinic -> save(clinic, patient) }
    }

    @Override
    void deleteByClinic(Clinic clinic) {
        findPatientsByClinic(clinic).each { patient -> delete(clinic, patient) }
    }

    @Override
    void deleteByPatient(Patient patient) {
        findClinicsByPatient(patient).each { clinic -> delete(clinic, patient) }
    }

    @Override
    void delete(Clinic clinic, Patient patient) {

        ClinicPatient clinicPatient =
            clinicPatientRepository.findByClinicAndPatientAndDateActive(clinic, patient, new Date())

        if (clinicPatient != null) {
            clinicPatient.thruDate = new Date()
            clinicPatientRepository.save(clinicPatient)
        }
    }

    @Override
    Iterable<Patient> findPatientsByClinic(Clinic clinic) {
        clinicPatientRepository
                .findByClinicAndDateActive(clinic, new Date())
                .collect { clinicPatient -> clinicPatient.patient }
    }

    @Override
    Iterable<Patient> findPatientsByClinicIdentifier(String clinicIdentifier) {
        clinicPatientRepository
                .findByClinicIdentifierAndDateActive(clinicIdentifier, new Date())
                .collect { clinicPatient -> clinicPatient.patient }
    }
            
    @Override
    Iterable<Patient> findPatientsByClinicIdentifierAndPatientIdentifier(String clinicIdentifier, String patientIdentifier) {
        clinicPatientRepository
                .findByClinicIdentifierAndPatientIdentifierAndDateActive(
                        clinicIdentifier,
                        patientIdentifier,
                        new Date()
                )
                .collect { clinicPatient -> clinicPatient.patient }
    }
         
    @Override
    Patient findOnePatientByClinicIdentifierAndPatientIdentifier(String clinicIdentifier, String patientIdentifier) {
        clinicPatientRepository
                .findOneByClinicIdentifierAndPatientIdentifierAndDateActive(
                        clinicIdentifier,
                        patientIdentifier,
                        new Date()
                )?.patient
    }

    @Override
    Iterable<Clinic> findClinicsByPatient(Patient patient) {
        clinicPatientRepository
                .findByPatientAndDateActive(patient, new Date())
                .collect { clinicPatient -> clinicPatient.clinic }
    }
}
