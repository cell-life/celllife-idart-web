package org.celllife.idart.application.part

import org.celllife.idart.common.PartId
import org.celllife.idart.domain.part.Part
import org.celllife.idart.domain.part.PartService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class PartApplicationServiceImpl implements PartApplicationService {

    @Inject PartService partService

    Part save(Part part) {
        partService.save(part)
    }

    Part findByPartId(PartId partId) {
        partService.findByPartId(partId)
    }

}
