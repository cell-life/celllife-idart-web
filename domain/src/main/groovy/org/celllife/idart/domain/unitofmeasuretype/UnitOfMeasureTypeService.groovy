package org.celllife.idart.domain.unitofmeasuretype

import org.celllife.idart.common.UnitOfMeasureTypeCode

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface UnitOfMeasureTypeService {

    Boolean exists(UnitOfMeasureTypeCode unitOfMeasureTypeCode)

    UnitOfMeasureType save(UnitOfMeasureType unitOfMeasureType)

    UnitOfMeasureType findByUnitOfMeasureTypeCode(UnitOfMeasureTypeCode unitOfMeasureTypeCode)

}
