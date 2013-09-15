package org.celllife.idart.domain.unitofmeasuretype

import org.celllife.idart.common.UnitOfMeasureTypeCode

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface UnitOfMeasureTypeRepository {

    boolean exists(UnitOfMeasureTypeCode unitOfMeasureTypeCode)

    UnitOfMeasureType save(UnitOfMeasureType unitOfMeasureType)

    UnitOfMeasureType findOne(UnitOfMeasureTypeCode unitOfMeasureTypeCode)

}
