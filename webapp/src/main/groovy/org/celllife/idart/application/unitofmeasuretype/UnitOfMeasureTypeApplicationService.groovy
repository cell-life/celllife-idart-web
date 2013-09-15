package org.celllife.idart.application.unitofmeasuretype

import org.celllife.idart.application.unitofmeasuretype.dto.UnitOfMeasureTypeDto
import org.celllife.idart.common.UnitOfMeasureTypeCode
import org.celllife.idart.domain.identifiable.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface UnitOfMeasureTypeApplicationService {

    Boolean exists(UnitOfMeasureTypeCode unitOfMeasureTypeCode)

    UnitOfMeasureTypeCode save(UnitOfMeasureTypeDto unitOfMeasureTypeDto)

    UnitOfMeasureTypeDto findByUnitOfMeasureTypeCode(UnitOfMeasureTypeCode unitOfMeasureTypeCode)

    UnitOfMeasureTypeDto findByIdentifier(Identifier identifier)

}
