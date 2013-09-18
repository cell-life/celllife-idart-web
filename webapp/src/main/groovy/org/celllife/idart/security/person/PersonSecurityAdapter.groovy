package org.celllife.idart.security.person

import org.celllife.idart.application.person.dto.PersonDto
import org.celllife.idart.common.PersonId
import org.celllife.idart.common.Identifier
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

    PersonId save(Principal principal, PersonDto personDto) {
        personApplicationService.save(personDto)
    }

    PersonDto findByPersonId(Principal principal, PersonId personId) {
        personApplicationService.findByPersonId(personId)
    }

    PersonDto findByIdentifier(Principal principal, Identifier identifier) {
        personApplicationService.findByIdentifier(identifier)
    }

}
