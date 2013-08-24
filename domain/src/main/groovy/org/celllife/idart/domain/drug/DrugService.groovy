package org.celllife.idart.domain.drug

import org.celllife.idart.common.PartId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface DrugService {

    Drug save(Drug drug) throws DrugValidationException

    Drug findByPartId(PartId partId) throws DrugNotFoundException

}
