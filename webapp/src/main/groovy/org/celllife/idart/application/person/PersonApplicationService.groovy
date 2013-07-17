package org.celllife.idart.application.person

import org.celllife.idart.domain.person.Person

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-15
 * Time: 23h08
 */
interface PersonApplicationService {

    Person save(Person person)

    Person update(Person newPerson, Long existingPersonPk)
}