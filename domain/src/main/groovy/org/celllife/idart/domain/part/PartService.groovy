package org.celllife.idart.domain.part

import org.celllife.idart.common.PartId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PartService {

    Part save(Part part) throws PartValidationException

    Part findByPartId(PartId partId) throws PartNotFoundException

}
