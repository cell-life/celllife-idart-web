package org.celllife.idart.domain.substitutionreason

import org.celllife.idart.common.EventHeader
import org.celllife.idart.common.EventType

import static org.celllife.idart.common.EventHeader.newEventHeader

import javax.annotation.Generated

/**
 * Substitution Reason Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class SubstitutionReasonEvent {

    EventHeader header

    SubstitutionReason substitutionReason

    static SubstitutionReasonEvent newSubstitutionReasonEvent(SubstitutionReason substitutionReason, SubstitutionReasonEvent.EventType eventType) {
        new SubstitutionReasonEvent(substitutionReason: substitutionReason, header: newEventHeader(eventType))
    }

    enum EventType implements org.celllife.idart.common.EventType {
        SAVED
    }
}
