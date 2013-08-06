package org.celllife.idart.application.unitofmeasuretype

import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureType
import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureTypeValidationException
import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureTypeNotFoundException
import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureTypeCode
import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureTypeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class UnitOfMeasureTypeApplicationServiceImpl implements UnitOfMeasureTypeApplicationService {

    @Autowired UnitOfMeasureTypeService unitOfMeasureTypeService

    UnitOfMeasureType save(UnitOfMeasureType unitOfMeasureType) throws UnitOfMeasureTypeValidationException {
        unitOfMeasureTypeService.save(unitOfMeasureType)
    }

    UnitOfMeasureType findByCode(UnitOfMeasureTypeCode code) throws UnitOfMeasureTypeNotFoundException{
        unitOfMeasureTypeService.findByCode(code)
    }

}