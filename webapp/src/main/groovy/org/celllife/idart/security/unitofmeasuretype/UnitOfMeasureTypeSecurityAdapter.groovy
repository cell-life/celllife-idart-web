package org.celllife.idart.security.unitofmeasuretype

import org.celllife.idart.common.UnitOfMeasureTypeCode
import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureType
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

    UnitOfMeasureType save(Principal principal, UnitOfMeasureType unitOfMeasureType) {
        unitOfMeasureTypeApplicationService.save(unitOfMeasureType)
    }

    UnitOfMeasureType findByUnitOfMeasureTypeCode(Principal principal, UnitOfMeasureTypeCode unitOfMeasureTypeCode) {
        unitOfMeasureTypeApplicationService.findByUnitOfMeasureTypeCode(unitOfMeasureTypeCode)
    }

}
