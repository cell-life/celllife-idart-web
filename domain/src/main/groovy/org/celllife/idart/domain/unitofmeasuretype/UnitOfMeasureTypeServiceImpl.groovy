package org.celllife.idart.domain.unitofmeasuretype

import org.celllife.idart.common.UnitOfMeasureTypeCode

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class UnitOfMeasureTypeServiceImpl implements UnitOfMeasureTypeService {

    @Autowired UnitOfMeasureTypeRepository unitOfMeasureTypeRepository

    @Autowired UnitOfMeasureTypeValidator unitOfMeasureTypeValidator

    @Autowired UnitOfMeasureTypeEventPublisher unitOfMeasureTypeEventPublisher

    @Override
    UnitOfMeasureType save(UnitOfMeasureType unitOfMeasureType) throws UnitOfMeasureTypeValidationException {

        unitOfMeasureTypeValidator.validate(unitOfMeasureType)

        unitOfMeasureTypeEventPublisher.unitOfMeasureTypeSaved(unitOfMeasureType)

        unitOfMeasureTypeRepository.save(unitOfMeasureType)
    }

    @Override
    UnitOfMeasureType findByUnitOfMeasureTypeCode(UnitOfMeasureTypeCode unitOfMeasureTypeCode) throws UnitOfMeasureTypeNotFoundException {

        def unitOfMeasureType = unitOfMeasureTypeRepository.findOne(unitOfMeasureTypeCode)

        if (unitOfMeasureType == null) {
            throw new UnitOfMeasureTypeNotFoundException("Could not find UnitOfMeasureType with Unit Of Measure Type Code [${ unitOfMeasureTypeCode}]")
        }

        unitOfMeasureType
    }
}