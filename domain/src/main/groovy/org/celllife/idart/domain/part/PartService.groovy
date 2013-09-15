package org.celllife.idart.domain.part

import org.celllife.idart.common.PartId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PartService {

    Boolean exists(PartId partId)

    Part save(Part part)

    Part findByPartId(PartId partId)

}
