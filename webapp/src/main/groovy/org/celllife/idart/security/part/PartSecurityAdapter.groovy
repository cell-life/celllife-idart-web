package org.celllife.idart.security.part

import org.celllife.idart.application.part.dto.PartDto
import org.celllife.idart.common.PartId
import org.celllife.idart.common.Identifier
import org.celllife.idart.application.part.PartApplicationService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class PartSecurityAdapter {

    @Inject PartApplicationService partApplicationService

    PartId save(Principal principal, partDto) {
        partApplicationService.save(partDto)
    }

    PartDto findByPartId(Principal principal, PartId partId) {
        partApplicationService.findByPartId(partId)
    }

    PartDto findByIdentifier(Principal principal, Identifier identifier) {
        partApplicationService.findByIdentifier(identifier)
    }

}
