package org.celllife.idart.application.drug

import org.celllife.idart.domain.drug.Drug
import org.celllife.idart.domain.drug.DrugValidationException
import org.celllife.idart.domain.drug.DrugNotFoundException
import org.celllife.idart.common.PartId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface DrugApplicationService {

    Drug save(Drug drug) throws DrugValidationException

    Drug findByPartId(PartId partId) throws DrugNotFoundException

}
