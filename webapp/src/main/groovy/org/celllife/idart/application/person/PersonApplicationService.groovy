package org.celllife.idart.application.person

import org.celllife.idart.domain.person.Person
import org.celllife.idart.domain.person.PersonValidationException
import org.celllife.idart.domain.person.PersonNotFoundException
import org.celllife.idart.common.PersonId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface PersonApplicationService {

    Person save(Person person) throws PersonValidationException

    Person findByPersonId(PersonId personId) throws PersonNotFoundException

}
