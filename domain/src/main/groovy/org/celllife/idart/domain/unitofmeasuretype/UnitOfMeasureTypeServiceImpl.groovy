package org.celllife.idart.domain.unitofmeasuretype

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class UnitOfMeasureTypeServiceImpl implements UnitOfMeasureTypeService {

    @Autowired UnitOfMeasureTypeRepository unitOfMeasureTypeRepository

    @Autowired UnitOfMeasureTypeValidator unitOfMeasureTypeValidator

    @Override
    UnitOfMeasureType save(UnitOfMeasureType unitOfMeasureType) throws UnitOfMeasureTypeValidationException {

        unitOfMeasureTypeValidator.validate(unitOfMeasureType)

        unitOfMeasureTypeRepository.save(unitOfMeasureType)
    }

    @Override
    UnitOfMeasureType findByCode(UnitOfMeasureTypeCode code) throws UnitOfMeasureTypeNotFoundException {

        def unitOfMeasureType = unitOfMeasureTypeRepository.findOne(code)

        if (unitOfMeasureType == null) {
            throw new UnitOfMeasureTypeNotFoundException("Could not find UnitOfMeasureType with Code [${ code}]")
        }

        unitOfMeasureType
    }
}