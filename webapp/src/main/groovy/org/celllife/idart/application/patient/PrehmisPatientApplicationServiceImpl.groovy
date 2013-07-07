package org.celllife.idart.application.patient

import org.celllife.idart.domain.partyrole.PartyRole
import org.celllife.idart.domain.patient.Patient
import org.celllife.idart.domain.patient.PatientService
import org.celllife.idart.domain.person.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 11h36
 */
@Service class PrehmisPatientApplicationServiceImpl implements PrehmisPatientApplicationService {

    @Autowired PersonRepository personRepository

    @Autowired PatientService patientService

    @Autowired PatientProvider prehmisPatientProvider

    @Autowired PatientCodeApplicationService patientCodeApplicationService

    void lookupAndSynchronise(String patientIdentifierValue, String clinicIdentifierValue) {
        savePatients(prehmisPatientProvider.findByIdentifier(clinicIdentifierValue, patientIdentifierValue))
    }

    void savePatients(Iterable<Patient> patients) {
        patients.each { newPatient -> savePatient(newPatient) }
    }

    void savePatient(Patient newPatient) {

        personRepository.save(newPatient.person)

        String patientIdentifierSystem = "http://www.cell-life.org/idart/patient"
        if (((PartyRole) newPatient).hasNoIdentifierForSystem(patientIdentifierSystem)) {
            String patientIdentifierValue = patientCodeApplicationService.nextPatientIdentifierValue()
            ((PartyRole) newPatient).addIdentifier(patientIdentifierSystem, patientIdentifierValue)
        }

        patientService.save(newPatient)
    }
}
