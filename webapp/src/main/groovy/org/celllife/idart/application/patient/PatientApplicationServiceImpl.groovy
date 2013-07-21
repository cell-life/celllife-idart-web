package org.celllife.idart.application.patient

import org.celllife.idart.application.ClinicNotFoundException
import org.celllife.idart.application.person.PersonApplicationService
import org.celllife.idart.domain.clinic.Clinic
import org.celllife.idart.domain.clinic.ClinicRepository
import org.celllife.idart.domain.facility.Facility
import org.celllife.idart.domain.patient.Patient
import org.celllife.idart.domain.patient.PatientSequence
import org.celllife.idart.domain.patient.PatientService
import org.celllife.idart.domain.person.Person
import org.celllife.idart.framework.aspectj.LogLevel
import org.celllife.idart.framework.aspectj.Loggable
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 11h36
 */
@Service class PatientApplicationServiceImpl implements PatientApplicationService, PatientResourceService {

    @Autowired ClinicRepository clinicRepository

    @Autowired PersonApplicationService personApplicationService

    @Autowired PatientService patientService

    @Autowired PatientProvider prehmisPatientProvider

    @Autowired PatientSequence patientCodeGenerator

    @Override
    @Loggable(value = LogLevel.INFO, exception = LogLevel.ERROR)
    List<Patient> findByIdentifier(String applicationId, String clinicIdentifier, String patientIdentifier) {

        Clinic clinic = clinicRepository.findOneByIdentifier("http://www.cell-life.org/idart/clinics", clinicIdentifier)

        if (clinic == null) {
            throw new ClinicNotFoundException("Clinic not found for identifier value: " + clinicIdentifier)
        }

        lookupFromExternalProviders(patientIdentifier, clinic).collect { patient -> save(patient) }
    }

    Patient save(Patient newPatient) {

        newPatient.person = updatePerson(newPatient)

        patientService.save(newPatient)
    }

    /**
     * Incoming patient's person may not have an identifier. This means that a new person will be created
     * everytime we update the patient. So to counter this:
     * 1: we lookup the person via the patient
     * 2a: If patient exists
     * 2b: Then so must the person, thus merge new Person into existing Person and save
     * 3a: If patient does not exist
     * 3b: Then the person might exist, but there is not way to be absolutely sure without a person identifier
     *     This may result in a duplicate person being created, we shall create a compensating work flow to handle
     *     the merging of duplicate people
     *
     * @param newPatient
     * @return
     */
    Person updatePerson(Patient newPatient) {

        def existingPatient = patientService.findByIdentifiers(newPatient.identifiers)

        if (existingPatient != null) {
            if (existingPatient.person == null) {
                // How did we manage to create a Patient with a Person... very very bad
                throw new RuntimeException("Something bad happened")
            }

            // TODO Try out alternative solution
            // newPatient.person.merge(existingPatient?.person)
            return newPatient.person = personApplicationService.update(newPatient.person, existingPatient.person?.pk)
        }

        return personApplicationService.save(newPatient.person)
    }

    Set<Patient> lookupFromExternalProviders(String patientIdentifierValue, Clinic clinic) {

        Set<Patient> patients = []

        for (String identifierSystem : ((Facility) clinic).identifierSystems) {
            String clinicIdentifierValue = ((Facility) clinic).getIdentifierValue(identifierSystem)
            switch (identifierSystem) {
                case "http://prehmis.capetown.gov.za":
                    patients << prehmisPatientProvider.findByIdentifier(clinicIdentifierValue, patientIdentifierValue)
                    break
                default:
                    break
            }
        }

        patients.flatten()
    }

    @Override
    Patient findByIdentifier(String identifier) {
        patientService.findByIdentifier(identifier)
    }

    @Override
    Iterable<Patient> findAll() {
        patientService.findAll()
    }
}
