package org.celllife.idart.domain.person

import org.celllife.idart.common.PersonId


/**
 */
public interface PersonRepository {

    boolean exists(PersonId personId)

    Person save(Person person)

    Person findOne(PersonId personId)

}
