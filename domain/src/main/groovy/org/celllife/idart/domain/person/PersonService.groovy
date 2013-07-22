package org.celllife.idart.domain.person

import org.celllife.idart.domain.common.Identifier

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-15
 * Time: 23h09
 */
interface PersonService {

    Person findByIdentifiers(Set<Identifier> identifiers)

    Person save(Person person)

    Person update(Person newPerson, Long existingPersonPk)

    Iterable<Person> findAll()

    Person findByIdentifier(String identifier)
}