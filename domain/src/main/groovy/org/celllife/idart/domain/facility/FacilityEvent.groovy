package org.celllife.idart.domain.facility

import org.celllife.idart.common.EventHeader

import static org.celllife.idart.common.EventHeader.newEventHeader

import javax.annotation.Generated

/**
 * Facility Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class FacilityEvent implements Serializable {

    EventHeader header

    Facility facility

    static FacilityEvent newFacilityEvent(Facility facility, FacilityEvent.EventType eventType) {
        new FacilityEvent(facility: facility, header: newEventHeader(eventType))
    }

    enum EventType implements org.celllife.idart.common.EventType {
        SAVED
    }
}
