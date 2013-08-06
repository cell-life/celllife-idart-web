package org.celllife.idart.domain.unitofmeasure

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface UnitOfMeasureRepository {

    UnitOfMeasure save(UnitOfMeasure unitOfMeasure)

    UnitOfMeasure findOne(UnitOfMeasureCode code)

}
