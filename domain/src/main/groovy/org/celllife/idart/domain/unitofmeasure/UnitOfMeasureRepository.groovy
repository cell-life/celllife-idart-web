package org.celllife.idart.domain.unitofmeasure

import org.celllife.idart.common.UnitOfMeasureCode

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface UnitOfMeasureRepository {

    boolean exists(UnitOfMeasureCode unitOfMeasureCode)

    UnitOfMeasure save(UnitOfMeasure unitOfMeasure)

    UnitOfMeasure findOne(UnitOfMeasureCode unitOfMeasureCode)

}
