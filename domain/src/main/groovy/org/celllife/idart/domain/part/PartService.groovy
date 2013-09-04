package org.celllife.idart.domain.part

import org.celllife.idart.common.PartId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PartService {

    Part save(Part part)

    Part findByPartId(PartId partId)

}
