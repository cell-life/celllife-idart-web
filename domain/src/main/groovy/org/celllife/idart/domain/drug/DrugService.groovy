package org.celllife.idart.domain.drug

import org.celllife.idart.common.PartIdentifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface DrugService {

    Drug save(Drug drug) throws DrugValidationException

    Drug findByPartIdentifier(PartIdentifier partIdentifier) throws DrugNotFoundException

}