package org.celllife.idart.domain.unitofmeasure

import javax.annotation.Generated

/**
 * Unit Of Measure Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class UnitOfMeasureEvent implements Serializable {

    Date timestamp

    UUID uuid

    EventType type

    String username

    UnitOfMeasure unitOfMeasure

    static UnitOfMeasureEvent newUnitOfMeasureEvent(UnitOfMeasure unitOfMeasure, UnitOfMeasureEvent.EventType eventType) {

        new UnitOfMeasureEvent(
            unitOfMeasure: unitOfMeasure,
            type: eventType,
            timestamp: new Date(),
            uuid: UUID.randomUUID()
        )
    }

    enum EventType {
        SAVED
    }
}
