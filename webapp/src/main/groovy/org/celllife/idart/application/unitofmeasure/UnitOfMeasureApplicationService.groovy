package org.celllife.idart.application.unitofmeasure

import org.celllife.idart.application.unitofmeasure.dto.UnitOfMeasureDto
import org.celllife.idart.common.UnitOfMeasureCode
import org.celllife.idart.domain.identifiable.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface UnitOfMeasureApplicationService {

    Boolean exists(UnitOfMeasureCode unitOfMeasureCode)

    UnitOfMeasureCode save(UnitOfMeasureDto unitOfMeasureDto)

    UnitOfMeasureDto findByUnitOfMeasureCode(UnitOfMeasureCode unitOfMeasureCode)

    UnitOfMeasureDto findByIdentifier(Identifier identifier)

}
