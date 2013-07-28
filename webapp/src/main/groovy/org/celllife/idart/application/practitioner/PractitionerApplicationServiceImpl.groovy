package org.celllife.idart.application.practitioner

import org.celllife.idart.application.person.PersonApplicationService
import org.celllife.idart.application.person.PersonResourceService
import org.celllife.idart.domain.person.Person
import org.celllife.idart.domain.practitioner.Practitioner
import org.celllife.idart.domain.practitioner.PractitionerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-29
 * Time: 12h16
 */
@Service class PractitionerApplicationServiceImpl implements PractitionerApplicationService, PractitionerResourceService {

    @Autowired PractitionerService practitionerService

    @Autowired PersonApplicationService personApplicationService

    @Autowired PersonResourceService personResourceService

    @Override
    Practitioner save(Practitioner newPractitioner) {

        newPractitioner.person = updatePerson(newPractitioner)

        practitionerService.save(newPractitioner)
    }

    @Override
    Practitioner findByIdentifier(String identifier) {
        return practitionerService.findByIdentifier(identifier)
    }

    @Override
    Iterable<Practitioner> findAll() {
        return practitionerService.findAll()
    }

    /**
     * Incoming practitioner's person may not have an identifier. This means that a new person will be created
     * everytime we update the practitioner. So to counter this:
     * 1: we lookup the person via the practitioner
     * 2a: If practitioner exists
     * 2b: Then so must the person, thus merge new Person into existing Person and save
     * 3a: If practitioner does not exist
     * 3b: Then the person might exist, but there is not way to be absolutely sure without a person identifier
     *     This may result in a duplicate person being created, we shall create a compensating work flow to handle
     *     the merging of duplicate people
     * @param newPractitioner
     * @return
     */
    Person updatePerson(Practitioner newPractitioner) {

        def existingPractitioner = practitionerService.findByIdentifiers(newPractitioner.identifiers)

        if (existingPractitioner != null) {
            if (existingPractitioner.person == null) {
                // How did we manage to create a Practitioner with a Person... very very bad
                throw new RuntimeException("Something bad happened")
            }

            existingPractitioner.person.merge(newPractitioner.person)
            newPractitioner.person = existingPractitioner.person
        }

        return personResourceService.save(newPractitioner.person)
    }
}
