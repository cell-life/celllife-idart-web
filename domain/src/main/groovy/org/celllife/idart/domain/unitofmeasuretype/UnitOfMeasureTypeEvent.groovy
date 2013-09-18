package org.celllife.idart.domain.unitofmeasuretype

import javax.annotation.Generated

/**
 * Unit Of Measure Type Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class UnitOfMeasureTypeEvent implements Serializable {

    Date timestamp

    UUID uuid

    EventType type

    String username

    UnitOfMeasureType unitOfMeasureType

    static UnitOfMeasureTypeEvent newUnitOfMeasureTypeEvent(UnitOfMeasureType unitOfMeasureType, UnitOfMeasureTypeEvent.EventType eventType) {

        new UnitOfMeasureTypeEvent(
            unitOfMeasureType: unitOfMeasureType,
            type: eventType,
            timestamp: new Date(),
            uuid: UUID.randomUUID()
        )
    }

    enum EventType {
        SAVED
    }
}
