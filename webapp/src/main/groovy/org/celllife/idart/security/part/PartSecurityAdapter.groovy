package org.celllife.idart.security.part

import org.celllife.idart.application.part.dto.PartDto
import org.celllife.idart.common.PartId
import org.celllife.idart.common.Identifier
import org.celllife.idart.application.part.PartApplicationService
import org.celllife.idart.common.PartType

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

/**
 */
@Named class PartSecurityAdapter {

    @Inject PartApplicationService partApplicationService

    PartId save(Principal principal, PartDto partDto) {
        partApplicationService.save(partDto)
    }

    PartDto findByPartId(Principal principal, PartId partId) {
        partApplicationService.findByPartId(partId)
    }

    PartDto findByIdentifier(Principal principal, Identifier identifier) {
        partApplicationService.findByIdentifier(identifier)
    }

    Set<PartDto> findByType(Principal principal, PartType type) {
        partApplicationService.findByType(type)
    }
}
