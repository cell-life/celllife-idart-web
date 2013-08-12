package org.celllife.idart.domain.unitofmeasure

import org.celllife.idart.common.EventHeader
import org.celllife.idart.common.EventType

import static org.celllife.idart.common.EventHeader.newEventHeader

import javax.annotation.Generated

/**
 * Unit Of Measure Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class UnitOfMeasureEvent {

    EventHeader header

    UnitOfMeasure unitOfMeasure

    static UnitOfMeasureEvent newUnitOfMeasureEvent(UnitOfMeasure unitOfMeasure, UnitOfMeasureEvent.EventType eventType) {
        new UnitOfMeasureEvent(unitOfMeasure: unitOfMeasure, header: newEventHeader(eventType))
    }

    enum EventType implements org.celllife.idart.common.EventType {
        SAVED
    }
}
