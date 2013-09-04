package org.celllife.idart.application.unitofmeasure

import org.celllife.idart.common.UnitOfMeasureCode
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class UnitOfMeasureApplicationServiceImpl implements UnitOfMeasureApplicationService {

    @Inject UnitOfMeasureService unitOfMeasureService

    UnitOfMeasure save(UnitOfMeasure unitOfMeasure) {
        unitOfMeasureService.save(unitOfMeasure)
    }

    UnitOfMeasure findByUnitOfMeasureCode(UnitOfMeasureCode unitOfMeasureCode) {
        unitOfMeasureService.findByUnitOfMeasureCode(unitOfMeasureCode)
    }

}
