package org.celllife.idart.domain.system

import org.celllife.idart.common.EventHeader
import org.celllife.idart.common.EventType

import static org.celllife.idart.common.EventHeader.newEventHeader

import javax.annotation.Generated

/**
 * System Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class SystemEvent {

    EventHeader header

    System system

    static SystemEvent newSystemEvent(System system, SystemEvent.EventType eventType) {
        new SystemEvent(system: system, header: newEventHeader(eventType))
    }

    enum EventType implements org.celllife.idart.common.EventType {
        SAVED
    }
}
