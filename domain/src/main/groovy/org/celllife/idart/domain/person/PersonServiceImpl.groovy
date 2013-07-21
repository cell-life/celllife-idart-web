package org.celllife.idart.domain.person

import org.celllife.idart.domain.common.Identifier
import org.celllife.idart.domain.party.Party
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import static org.celllife.idart.domain.person.People.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-15
 * Time: 23h09
 */
@Service class PersonServiceImpl implements PersonService {

    @Autowired PersonRepository personRepository

    @Autowired PersonSequence personSequence

    @Override
    Person findByIdentifiers(Set<Identifier> identifiers) {

        for (identifier in identifiers) {
            Person person = personRepository.findOneByIdentifier(identifier.system, identifier.value)
            if (person != null) {
                return person
            }
        }

        null
    }

    @Override
    Person save(Person newPerson) {
        merge(newPerson, findByIdentifiers(newPerson.identifiers))
    }

    @Override
    Person update(Person newPerson, Long existingPersonPk) {
        def existingPerson = personRepository.findOne(existingPersonPk)
        merge(newPerson, existingPerson)
    }

    Person merge(Person newPerson, Person existingPerson) {

        if (requiresIdartIdentifier(newPerson, existingPerson)) {
            ((Party) newPerson).addIdentifier(IDART_PERSON_IDENTIFIER_SYSTEM, nextPersonIdentifier())
        }

        if (existingPerson != null) {
            existingPerson.merge(newPerson)
            return personRepository.save(existingPerson)
        }

        return personRepository.save(newPerson)
    }

    private String nextPersonIdentifier() {
        String.format(IDART_PERSON_IDENTIFIER_FORMAT, personSequence.nextValue())
    }
}
