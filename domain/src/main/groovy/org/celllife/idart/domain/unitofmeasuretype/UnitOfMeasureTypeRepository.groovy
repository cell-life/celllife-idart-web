package org.celllife.idart.domain.unitofmeasuretype

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface UnitOfMeasureTypeRepository {

    UnitOfMeasureType save(UnitOfMeasureType unitOfMeasureType)

    UnitOfMeasureType findOne(UnitOfMeasureTypeCode code)

}
