package org.celllife.idart.domain.unitofmeasuretype

import org.celllife.idart.common.UnitOfMeasureTypeCode

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface UnitOfMeasureTypeRepository {

    UnitOfMeasureType save(UnitOfMeasureType unitOfMeasureType)

    UnitOfMeasureType findOne(UnitOfMeasureTypeCode unitOfMeasureTypeCode)

}