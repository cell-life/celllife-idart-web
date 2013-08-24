package org.celllife.idart.application.compound

import org.celllife.idart.domain.compound.Compound
import org.celllife.idart.domain.compound.CompoundValidationException
import org.celllife.idart.domain.compound.CompoundNotFoundException
import org.celllife.idart.common.PartId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface CompoundApplicationService {

    Compound save(Compound compound) throws CompoundValidationException

    Compound findByPartId(PartId partId) throws CompoundNotFoundException

}
