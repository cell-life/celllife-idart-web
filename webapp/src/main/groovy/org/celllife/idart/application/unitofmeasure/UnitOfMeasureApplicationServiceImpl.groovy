package org.celllife.idart.application.unitofmeasure

import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureValidationException
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureNotFoundException
import org.celllife.idart.common.UnitOfMeasureCode
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class UnitOfMeasureApplicationServiceImpl implements UnitOfMeasureApplicationService {

    @Autowired UnitOfMeasureService unitOfMeasureService

    UnitOfMeasure save(UnitOfMeasure unitOfMeasure) throws UnitOfMeasureValidationException {
        unitOfMeasureService.save(unitOfMeasure)
    }

    UnitOfMeasure findByUnitOfMeasureCode(UnitOfMeasureCode unitOfMeasureCode) throws UnitOfMeasureNotFoundException{
        unitOfMeasureService.findByUnitOfMeasureCode(unitOfMeasureCode)
    }

}