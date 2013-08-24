package org.celllife.idart.domain.part

import org.celllife.idart.common.EventHeader
import org.celllife.idart.common.EventType

import static org.celllife.idart.common.EventHeader.newEventHeader

import javax.annotation.Generated

/**
 * Part Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PartEvent {

    EventHeader header

    Part part

    static PartEvent newPartEvent(Part part, PartEvent.EventType eventType) {
        new PartEvent(part: part, header: newEventHeader(eventType))
    }

    enum EventType implements org.celllife.idart.common.EventType {
        SAVED
    }
}
