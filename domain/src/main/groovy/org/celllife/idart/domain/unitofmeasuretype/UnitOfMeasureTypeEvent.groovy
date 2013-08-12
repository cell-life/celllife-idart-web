package org.celllife.idart.domain.unitofmeasuretype

import org.celllife.idart.common.EventHeader
import org.celllife.idart.common.EventType

import static org.celllife.idart.common.EventHeader.newEventHeader

import javax.annotation.Generated

/**
 * Unit Of Measure Type Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class UnitOfMeasureTypeEvent {

    EventHeader header

    UnitOfMeasureType unitOfMeasureType

    static UnitOfMeasureTypeEvent newUnitOfMeasureTypeEvent(UnitOfMeasureType unitOfMeasureType, UnitOfMeasureTypeEvent.EventType eventType) {
        new UnitOfMeasureTypeEvent(unitOfMeasureType: unitOfMeasureType, header: newEventHeader(eventType))
    }

    enum EventType implements org.celllife.idart.common.EventType {
        SAVED
    }
}
