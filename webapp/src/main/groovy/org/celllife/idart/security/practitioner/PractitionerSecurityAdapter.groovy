package org.celllife.idart.security.practitioner

import org.celllife.idart.application.practitioner.PractitionerApplicationService
import org.celllife.idart.application.practitioner.dto.PractitionerDto
import org.celllife.idart.common.PractitionerId
import org.celllife.idart.common.Identifier
import org.celllife.idart.framework.security.IdartSystem
import org.celllife.idart.framework.security.IdartUser

import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

import static org.celllife.idart.framework.security.Principals.getUser

/**
 */
@Named class PractitionerSecurityAdapter {

    @Inject PractitionerApplicationService practitionerApplicationService

    PractitionerId save(Principal principal, PractitionerDto practitionerDto) {
        practitionerApplicationService.save(practitionerDto)
    }

    PractitionerDto findByIdentifier(Principal principal, Identifier identifier) {
        practitionerApplicationService.findByIdentifier(identifier)
    }

    Set<PractitionerDto> findAll(Principal principal) {

        def user = getUser(principal)

        if (user instanceof IdartSystem) {
            return practitionerApplicationService.findBySystem((user as IdartSystem).id)
        }

        if (user instanceof IdartUser) {
            return practitionerApplicationService.findByPerson((user as IdartUser).person)
        }

        throw new IllegalArgumentException("Principal of type [${principal.class}] is not supported.")
    }
}
