package org.celllife.idart.domain.person

import org.celllife.idart.common.PersonId

import javax.annotation.Generated

/**
 */
public interface PersonService {

    Person save(Person person)

    Person findByPersonId(PersonId personId)

}
