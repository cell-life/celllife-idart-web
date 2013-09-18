package org.celllife.idart.domain.facility


/**
 * Facility Domain Event
 */
class FacilityEvent implements Serializable {

    Date timestamp

    UUID uuid

    EventType type

    String username

    Facility facility

    static FacilityEvent newFacilityEvent(Facility facility, FacilityEvent.EventType eventType) {

        new FacilityEvent(
            facility: facility,
            type: eventType,
            timestamp: new Date(),
            uuid: UUID.randomUUID()
        )
    }

    enum EventType {
        SAVED
    }
}
