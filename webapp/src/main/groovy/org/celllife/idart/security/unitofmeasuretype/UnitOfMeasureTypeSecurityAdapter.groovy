package org.celllife.idart.security.unitofmeasuretype

import org.celllife.idart.application.unitofmeasuretype.dto.UnitOfMeasureTypeDto
import org.celllife.idart.common.UnitOfMeasureTypeCode
import org.celllife.idart.common.Identifier
import org.celllife.idart.application.unitofmeasuretype.UnitOfMeasureTypeApplicationService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class UnitOfMeasureTypeSecurityAdapter {

    @Inject UnitOfMeasureTypeApplicationService unitOfMeasureTypeApplicationService

    UnitOfMeasureTypeCode save(Principal principal, UnitOfMeasureTypeDto unitOfMeasureTypeDto) {
        unitOfMeasureTypeApplicationService.save(unitOfMeasureTypeDto)
    }

    UnitOfMeasureTypeDto findByUnitOfMeasureTypeCode(Principal principal, UnitOfMeasureTypeCode unitOfMeasureTypeCode) {
        unitOfMeasureTypeApplicationService.findByUnitOfMeasureTypeCode(unitOfMeasureTypeCode)
    }

    UnitOfMeasureTypeDto findByIdentifier(Principal principal, Identifier identifier) {
        unitOfMeasureTypeApplicationService.findByIdentifier(identifier)
    }

}
