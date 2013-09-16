package org.celllife.idart.security.dispensation

import org.celllife.idart.application.dispensation.dto.DispensationDto
import org.celllife.idart.common.DispensationId
import org.celllife.idart.common.Identifier
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

    DispensationId save(Principal principal, dispensationDto) {
        dispensationApplicationService.save(dispensationDto)
    }

    DispensationDto findByDispensationId(Principal principal, DispensationId dispensationId) {
        dispensationApplicationService.findByDispensationId(dispensationId)
    }

    DispensationDto findByIdentifier(Principal principal, Identifier identifier) {
        dispensationApplicationService.findByIdentifier(identifier)
    }

}
