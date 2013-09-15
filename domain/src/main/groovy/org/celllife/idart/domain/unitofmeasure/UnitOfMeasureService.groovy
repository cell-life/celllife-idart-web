package org.celllife.idart.domain.unitofmeasure

import org.celllife.idart.common.UnitOfMeasureCode

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface UnitOfMeasureService {

    Boolean exists(UnitOfMeasureCode unitOfMeasureCode)

    UnitOfMeasure save(UnitOfMeasure unitOfMeasure)

    UnitOfMeasure findByUnitOfMeasureCode(UnitOfMeasureCode unitOfMeasureCode)

}
