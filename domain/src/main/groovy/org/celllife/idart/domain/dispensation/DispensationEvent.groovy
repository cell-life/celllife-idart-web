package org.celllife.idart.domain.dispensation

import org.celllife.idart.common.EventHeader
import org.celllife.idart.common.EventType

import static org.celllife.idart.common.EventHeader.newEventHeader

import javax.annotation.Generated

/**
 * Dispensation Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class DispensationEvent {

    EventHeader header

    Dispensation dispensation

    static DispensationEvent newDispensationEvent(Dispensation dispensation, DispensationEvent.EventType eventType) {
        new DispensationEvent(dispensation: dispensation, header: newEventHeader(eventType))
    }

    enum EventType implements org.celllife.idart.common.EventType {
        SAVED
    }
}
