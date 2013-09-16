package org.celllife.idart.domain.entrysite

import org.celllife.idart.common.EventHeader

import static org.celllife.idart.common.EventHeader.newEventHeader

import javax.annotation.Generated

/**
 * Entry Site Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class EntrySiteEvent implements Serializable {

    EventHeader header

    EntrySite entrySite

    static EntrySiteEvent newEntrySiteEvent(EntrySite entrySite, EntrySiteEvent.EventType eventType) {
        new EntrySiteEvent(entrySite: entrySite, header: newEventHeader(eventType))
    }

    enum EventType implements org.celllife.idart.common.EventType {
        SAVED
    }
}
