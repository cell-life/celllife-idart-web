package org.celllife.idart.domain.person

import org.celllife.idart.domain.common.Identifier
import org.celllife.idart.domain.party.Party
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

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
        Person existingPerson = personRepository.findOne(existingPersonPk)
        merge(newPerson, existingPerson)
    }

    Person merge(Person newPerson, Person existingPerson) {

        if (requiresIdartIdentifier(newPerson, existingPerson)) {
            ((Party) newPerson).addIdentifier(Person.IDART_SYSTEM, nextPersonIdentifier())
        }

        if (existingPerson != null) {
            existingPerson.merge(newPerson)
            return personRepository.save(existingPerson)
        }

        return personRepository.save(newPerson)
    }

    private String nextPersonIdentifier() {
        String.format("%08d", personSequence.nextValue())
    }

    /**
     * Iterate through people and check if any have an iDART identifier
     *
     * @param people
     * @return
     */
    private static requiresIdartIdentifier(Person... people) {

        for (Person person in people) {
            if (((Party) person)?.hasIdentifierForSystem(Person.IDART_SYSTEM)) {
                return false
            }
        }

        return true
    }
}
