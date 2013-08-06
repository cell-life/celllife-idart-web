package org.celllife.idart.domain.unitofmeasure

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    @Autowired UnitOfMeasureRepository unitOfMeasureRepository

    @Autowired UnitOfMeasureValidator unitOfMeasureValidator

    @Override
    UnitOfMeasure save(UnitOfMeasure unitOfMeasure) throws UnitOfMeasureValidationException {

        unitOfMeasureValidator.validate(unitOfMeasure)

        unitOfMeasureRepository.save(unitOfMeasure)
    }

    @Override
    UnitOfMeasure findByCode(UnitOfMeasureCode code) throws UnitOfMeasureNotFoundException {

        def unitOfMeasure = unitOfMeasureRepository.findOne(code)

        if (unitOfMeasure == null) {
            throw new UnitOfMeasureNotFoundException("Could not find UnitOfMeasure with Code [${ code}]")
        }

        unitOfMeasure
    }
}