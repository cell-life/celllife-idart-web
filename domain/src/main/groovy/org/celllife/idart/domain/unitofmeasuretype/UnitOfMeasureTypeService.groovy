package org.celllife.idart.domain.unitofmeasuretype

import org.celllife.idart.common.UnitOfMeasureTypeCode

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface UnitOfMeasureTypeService {

    UnitOfMeasureType save(UnitOfMeasureType unitOfMeasureType) throws UnitOfMeasureTypeValidationException

    UnitOfMeasureType findByUnitOfMeasureTypeCode(UnitOfMeasureTypeCode unitOfMeasureTypeCode) throws UnitOfMeasureTypeNotFoundException

}
