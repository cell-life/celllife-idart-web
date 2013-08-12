package org.celllife.idart.domain.unitofmeasure

import org.celllife.idart.common.UnitOfMeasureCode

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    @Autowired UnitOfMeasureRepository unitOfMeasureRepository

    @Autowired UnitOfMeasureValidator unitOfMeasureValidator

    @Autowired UnitOfMeasureEventPublisher unitOfMeasureEventPublisher

    @Override
    UnitOfMeasure save(UnitOfMeasure unitOfMeasure) throws UnitOfMeasureValidationException {

        unitOfMeasureValidator.validate(unitOfMeasure)

        unitOfMeasureEventPublisher.unitOfMeasureSaved(unitOfMeasure)

        unitOfMeasureRepository.save(unitOfMeasure)
    }

    @Override
    UnitOfMeasure findByUnitOfMeasureCode(UnitOfMeasureCode unitOfMeasureCode) throws UnitOfMeasureNotFoundException {

        def unitOfMeasure = unitOfMeasureRepository.findOne(unitOfMeasureCode)

        if (unitOfMeasure == null) {
            throw new UnitOfMeasureNotFoundException("Could not find UnitOfMeasure with Unit Of Measure Code [${ unitOfMeasureCode}]")
        }

        unitOfMeasure
    }
}