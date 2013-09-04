package org.celllife.idart.security.part

import org.celllife.idart.common.PartId
import org.celllife.idart.domain.part.Part
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

    Part save(Principal principal, Part part) {
        partApplicationService.save(part)
    }

    Part findByPartId(Principal principal, PartId partId) {
        partApplicationService.findByPartId(partId)
    }

}
