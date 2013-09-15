package org.celllife.idart.domain.unitofmeasuretype

import org.celllife.idart.common.UnitOfMeasureTypeCode

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureTypeEvent.EventType.SAVED
import static org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureTypeEvent.newUnitOfMeasureTypeEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class UnitOfMeasureTypeServiceImpl implements UnitOfMeasureTypeService {

    @Inject UnitOfMeasureTypeRepository unitOfMeasureTypeRepository

    @Inject UnitOfMeasureTypeValidator unitOfMeasureTypeValidator

    @Inject UnitOfMeasureTypeEventPublisher unitOfMeasureTypeEventPublisher
    
    @Override
    Boolean exists(UnitOfMeasureTypeCode unitOfMeasureTypeCode) {
        unitOfMeasureTypeRepository.exists(unitOfMeasureTypeCode)
    }
    
    @Override
    UnitOfMeasureType save(UnitOfMeasureType unitOfMeasureType) {

        unitOfMeasureTypeValidator.validate(unitOfMeasureType)

        unitOfMeasureTypeEventPublisher.publish(newUnitOfMeasureTypeEvent(unitOfMeasureType, SAVED))

        unitOfMeasureTypeRepository.save(unitOfMeasureType)
    }
    
    @Override
    UnitOfMeasureType findByUnitOfMeasureTypeCode(UnitOfMeasureTypeCode unitOfMeasureTypeCode) {

        def unitOfMeasureType = unitOfMeasureTypeRepository.findOne(unitOfMeasureTypeCode)

        if (unitOfMeasureType == null) {
            throw new UnitOfMeasureTypeNotFoundException("Could not find UnitOfMeasureType with code [${ unitOfMeasureTypeCode}]")
        }

        unitOfMeasureType
    }
}
