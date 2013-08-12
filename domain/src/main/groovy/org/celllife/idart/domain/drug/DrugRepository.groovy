package org.celllife.idart.domain.drug

import org.celllife.idart.common.PartIdentifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface DrugRepository {

    Drug save(Drug drug)

    Drug findOne(PartIdentifier partIdentifier)

}
