package org.celllife.idart.application.part

import org.celllife.idart.common.PartId
import org.celllife.idart.domain.part.Part

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface PartApplicationService {

    Part save(Part part)

    Part findByPartId(PartId partId)

}
