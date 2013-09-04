package org.celllife.idart.security.person

import org.celllife.idart.common.PersonId
import org.celllife.idart.domain.person.Person
import org.celllife.idart.application.person.PersonApplicationService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class PersonSecurityAdapter {

    @Inject PersonApplicationService personApplicationService

    Person save(Principal principal, Person person) {
        personApplicationService.save(person)
    }

    Person findByPersonId(Principal principal, PersonId personId) {
        personApplicationService.findByPersonId(personId)
    }

}
