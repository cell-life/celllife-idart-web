package org.celllife.idart.security.practitioner

import org.celllife.idart.common.PractitionerId
import org.celllife.idart.domain.practitioner.Practitioner
import org.celllife.idart.application.practitioner.PractitionerApplicationService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class PractitionerSecurityAdapter {

    @Inject PractitionerApplicationService practitionerApplicationService

    Practitioner save(Principal principal, Practitioner practitioner) {
        practitionerApplicationService.save(practitioner)
    }

    Practitioner findByPractitionerId(Principal principal, PractitionerId practitionerId) {
        practitionerApplicationService.findByPractitionerId(practitionerId)
    }

}
