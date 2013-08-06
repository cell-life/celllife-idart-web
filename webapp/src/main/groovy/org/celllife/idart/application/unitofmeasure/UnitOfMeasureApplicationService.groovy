package org.celllife.idart.application.unitofmeasure

import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureValidationException
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureNotFoundException
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureCode

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface UnitOfMeasureApplicationService {

    UnitOfMeasure save(UnitOfMeasure unitOfMeasure) throws UnitOfMeasureValidationException

    UnitOfMeasure findByCode(UnitOfMeasureCode code) throws UnitOfMeasureNotFoundException

}