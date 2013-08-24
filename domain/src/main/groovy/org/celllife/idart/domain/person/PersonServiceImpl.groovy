package org.celllife.idart.domain.person

import org.celllife.idart.common.PersonId

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

import static org.celllife.idart.domain.person.PersonEvent.EventType.SAVED
import static org.celllife.idart.domain.person.PersonEvent.newPersonEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class PersonServiceImpl implements PersonService {

    @Autowired PersonRepository personRepository

    @Autowired PersonValidator personValidator

    @Autowired PersonEventPublisher personEventPublisher

    @Override
    Person save(Person person) throws PersonValidationException {

        personValidator.validate(person)

        personEventPublisher.publish(newPersonEvent(person, SAVED))

        personRepository.save(person)
    }

    @Override
    Person findByPersonId(PersonId personId) throws PersonNotFoundException {

        def person = personRepository.findOne(personId)

        if (person == null) {
            throw new PersonNotFoundException("Could not find Person with Person Id [${ personId}]")
        }

        person
    }
}
