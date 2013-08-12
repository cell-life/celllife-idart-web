package org.celllife.idart.domain.compound

import org.celllife.idart.common.PartIdentifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface CompoundRepository {

    Compound save(Compound compound)

    Compound findOne(PartIdentifier partIdentifier)

}
