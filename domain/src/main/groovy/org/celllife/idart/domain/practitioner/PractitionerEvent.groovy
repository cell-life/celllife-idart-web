package org.celllife.idart.domain.practitioner

import org.celllife.idart.common.EventHeader
import org.celllife.idart.common.EventType

import static org.celllife.idart.common.EventHeader.newEventHeader

import javax.annotation.Generated

/**
 * Practitioner Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PractitionerEvent {

    EventHeader header

    Practitioner practitioner

    static PractitionerEvent newPractitionerEvent(Practitioner practitioner, PractitionerEvent.EventType eventType) {
        new PractitionerEvent(practitioner: practitioner, header: newEventHeader(eventType))
    }

    enum EventType implements org.celllife.idart.common.EventType {
        SAVED
    }
}
