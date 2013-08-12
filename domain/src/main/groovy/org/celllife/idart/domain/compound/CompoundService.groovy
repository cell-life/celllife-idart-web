package org.celllife.idart.domain.compound

import org.celllife.idart.common.PartIdentifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface CompoundService {

    Compound save(Compound compound) throws CompoundValidationException

    Compound findByPartIdentifier(PartIdentifier partIdentifier) throws CompoundNotFoundException

}