package org.celllife.idart.domain.unitofmeasure

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface UnitOfMeasureService {

    UnitOfMeasure save(UnitOfMeasure unitOfMeasure) throws UnitOfMeasureValidationException

    UnitOfMeasure findByCode(UnitOfMeasureCode code) throws UnitOfMeasureNotFoundException

}