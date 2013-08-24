package org.celllife.idart.domain.person

import org.celllife.idart.common.PersonId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PersonRepository {

    Person save(Person person)

    Person findOne(PersonId personId)

}
