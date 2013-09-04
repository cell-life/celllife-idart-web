package org.celllife.idart.application.unitofmeasuretype

import org.celllife.idart.common.UnitOfMeasureTypeCode
import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureType

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface UnitOfMeasureTypeApplicationService {

    UnitOfMeasureType save(UnitOfMeasureType unitOfMeasureType)

    UnitOfMeasureType findByUnitOfMeasureTypeCode(UnitOfMeasureTypeCode unitOfMeasureTypeCode)

}
