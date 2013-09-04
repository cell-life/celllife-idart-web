package org.celllife.idart.application.unitofmeasure

import org.celllife.idart.common.UnitOfMeasureCode
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface UnitOfMeasureApplicationService {

    UnitOfMeasure save(UnitOfMeasure unitOfMeasure)

    UnitOfMeasure findByUnitOfMeasureCode(UnitOfMeasureCode unitOfMeasureCode)

}
