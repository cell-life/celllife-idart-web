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

        def existingUnitOfMeasure = unitOfMeasureRepository.findOne(unitOfMeasure.id)

        if (existingUnitOfMeasure == null) {
            existingUnitOfMeasure = unitOfMeasure
        } else {
            existingUnitOfMeasure.merge(unitOfMeasure)
        }

        unitOfMeasureValidator.validate(existingUnitOfMeasure)

        unitOfMeasureEventPublisher.publish(newUnitOfMeasureEvent(existingUnitOfMeasure, SAVED))

        unitOfMeasureRepository.save(existingUnitOfMeasure)
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
