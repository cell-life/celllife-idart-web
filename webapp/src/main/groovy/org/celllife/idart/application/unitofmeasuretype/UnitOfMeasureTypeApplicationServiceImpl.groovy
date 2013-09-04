package org.celllife.idart.application.unitofmeasuretype

import org.celllife.idart.common.UnitOfMeasureTypeCode
import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureType
import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureTypeService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class UnitOfMeasureTypeApplicationServiceImpl implements UnitOfMeasureTypeApplicationService {

    @Inject UnitOfMeasureTypeService unitOfMeasureTypeService

    UnitOfMeasureType save(UnitOfMeasureType unitOfMeasureType) {
        unitOfMeasureTypeService.save(unitOfMeasureType)
    }

    UnitOfMeasureType findByUnitOfMeasureTypeCode(UnitOfMeasureTypeCode unitOfMeasureTypeCode) {
        unitOfMeasureTypeService.findByUnitOfMeasureTypeCode(unitOfMeasureTypeCode)
    }

}
