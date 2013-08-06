package org.celllife.idart.domain.unitofmeasuretype

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface UnitOfMeasureTypeService {

    UnitOfMeasureType save(UnitOfMeasureType unitOfMeasureType) throws UnitOfMeasureTypeValidationException

    UnitOfMeasureType findByCode(UnitOfMeasureTypeCode code) throws UnitOfMeasureTypeNotFoundException

}