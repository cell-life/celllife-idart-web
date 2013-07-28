package org.celllife.idart.application.patient

import org.celllife.idart.application.person.PersonApplicationService
import org.celllife.idart.application.person.PersonResourceService
import org.celllife.idart.domain.patient.Patient
import org.celllife.idart.domain.patient.PatientService
import org.celllife.idart.domain.person.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 11h36
 */
@Service class PatientApplicationServiceImpl implements PatientApplicationService, PatientResourceService {

    @Autowired PersonApplicationService personApplicationService

    @Autowired PersonResourceService personResourceService

    @Autowired PatientService patientService

    @Override
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

            existingPatient.person.merge(newPatient.person)
            newPatient.person = existingPatient.person
        }

        return personResourceService.save(newPatient.person)
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
