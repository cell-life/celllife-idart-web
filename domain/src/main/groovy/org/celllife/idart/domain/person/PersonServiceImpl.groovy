package org.celllife.idart.domain.person

import org.celllife.idart.common.PartyIdentifier

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

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

        personEventPublisher.personSaved(person)

        personRepository.save(person)
    }

    @Override
    Person findByPartyIdentifier(PartyIdentifier partyIdentifier) throws PersonNotFoundException {

        def person = personRepository.findOne(partyIdentifier)

        if (person == null) {
            throw new PersonNotFoundException("Could not find Person with Party Identifier [${ partyIdentifier}]")
        }

        person
    }
}