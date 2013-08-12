package org.celllife.idart.domain.compound

import org.celllife.idart.common.EventHeader
import org.celllife.idart.common.EventType

import static org.celllife.idart.common.EventHeader.newEventHeader

import javax.annotation.Generated

/**
 * Compound Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class CompoundEvent {

    EventHeader header

    Compound compound

    static CompoundEvent newCompoundEvent(Compound compound, CompoundEvent.EventType eventType) {
        new CompoundEvent(compound: compound, header: newEventHeader(eventType))
    }

    enum EventType implements org.celllife.idart.common.EventType {
        SAVED
    }
}
