package org.celllife.idart.security.dispensation

import org.celllife.idart.common.DispensationId
import org.celllife.idart.domain.dispensation.Dispensation
import org.celllife.idart.application.dispensation.DispensationApplicationService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class DispensationSecurityAdapter {

    @Inject DispensationApplicationService dispensationApplicationService

    Dispensation save(Principal principal, Dispensation dispensation) {
        dispensationApplicationService.save(dispensation)
    }

    Dispensation findByDispensationId(Principal principal, DispensationId dispensationId) {
        dispensationApplicationService.findByDispensationId(dispensationId)
    }

}
