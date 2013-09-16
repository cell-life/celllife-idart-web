package org.celllife.idart.domain.person

import org.celllife.idart.common.PersonId

/**
 */
public interface PersonService {

    Person save(Person person)

    Person findByPersonId(PersonId personId)

    Boolean exists(PersonId personId)
}
