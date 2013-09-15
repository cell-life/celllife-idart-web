package org.celllife.idart.domain.unitofmeasure

import org.celllife.idart.common.UnitOfMeasureCode

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.domain.unitofmeasure.UnitOfMeasureEvent.EventType.SAVED
import static org.celllife.idart.domain.unitofmeasure.UnitOfMeasureEvent.newUnitOfMeasureEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    @Inject UnitOfMeasureRepository unitOfMeasureRepository

    @Inject UnitOfMeasureValidator unitOfMeasureValidator

    @Inject UnitOfMeasureEventPublisher unitOfMeasureEventPublisher
    
    @Override
    Boolean exists(UnitOfMeasureCode unitOfMeasureCode) {
        unitOfMeasureRepository.exists(unitOfMeasureCode)
    }
    
    @Override
    UnitOfMeasure save(UnitOfMeasure unitOfMeasure) {

        unitOfMeasureValidator.validate(unitOfMeasure)

        unitOfMeasureEventPublisher.publish(newUnitOfMeasureEvent(unitOfMeasure, SAVED))

        unitOfMeasureRepository.save(unitOfMeasure)
    }
    
    @Override
    UnitOfMeasure findByUnitOfMeasureCode(UnitOfMeasureCode unitOfMeasureCode) {

        def unitOfMeasure = unitOfMeasureRepository.findOne(unitOfMeasureCode)

        if (unitOfMeasure == null) {
            throw new UnitOfMeasureNotFoundException("Could not find UnitOfMeasure with code [${ unitOfMeasureCode}]")
        }

        unitOfMeasure
    }
}
