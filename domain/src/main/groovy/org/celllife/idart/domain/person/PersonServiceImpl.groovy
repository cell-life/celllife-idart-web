package org.celllife.idart.domain.person

import org.celllife.idart.common.PersonId
import org.celllife.idart.domain.identifiable.IdentifiableSeqeuence

import javax.inject.Inject
import javax.inject.Named

import static java.lang.String.format
import static org.celllife.idart.common.PersonId.personId
import static org.celllife.idart.common.IdentifiableType.PERSON
import static org.celllife.idart.domain.person.PersonEvent.EventType.SAVED
import static org.celllife.idart.domain.person.PersonEvent.newPersonEvent

/**
 */
@Named class PersonServiceImpl implements PersonService {

    @Inject PersonRepository personRepository

    @Inject PersonValidator personValidator

    @Inject PersonEventPublisher personEventPublisher

    @Inject IdentifiableSeqeuence identifiableSeqeuence

    @Override
    Person save(Person person) {

        def existingPerson = null

        if (person.id != null) {
            existingPerson = personRepository.findOne(person.id)
        } else {
            def value = identifiableSeqeuence.nextValue(PERSON)
            person.id = personId(format("%08d", value))
        }

        if (existingPerson == null) {
            existingPerson = person
        } else {
            existingPerson.merge(person)
        }

        personValidator.validate(existingPerson)

        personEventPublisher.publish(newPersonEvent(existingPerson, SAVED))

        personRepository.save(existingPerson)
    }

    @Override
    Person findByPersonId(PersonId personId) {

        def person = personRepository.findOne(personId)

        if (person == null) {
            throw new PersonNotFoundException("Could not find Person with Person Id [${ personId}]")
        }

        person
    }

    @Override
    Boolean exists(PersonId personId) {
        personRepository.exists(personId)
    }
}
