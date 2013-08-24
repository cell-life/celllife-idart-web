package org.celllife.idart.domain.compound

import org.celllife.idart.common.PartId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface CompoundService {

    Compound save(Compound compound) throws CompoundValidationException

    Compound findByPartId(PartId partId) throws CompoundNotFoundException

}
