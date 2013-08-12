package org.celllife.idart.domain.indication

import org.celllife.idart.common.EventHeader
import org.celllife.idart.common.EventType

import static org.celllife.idart.common.EventHeader.newEventHeader

import javax.annotation.Generated

/**
 * Indication Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class IndicationEvent {

    EventHeader header

    Indication indication

    static IndicationEvent newIndicationEvent(Indication indication, IndicationEvent.EventType eventType) {
        new IndicationEvent(indication: indication, header: newEventHeader(eventType))
    }

    enum EventType implements org.celllife.idart.common.EventType {
        SAVED
    }
}
