package org.celllife.idart.domain.substitutionreason

import javax.annotation.Generated

/**
 * Substitution Reason Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class SubstitutionReasonEvent implements Serializable {

    Date timestamp

    UUID uuid

    EventType type

    String username

    SubstitutionReason substitutionReason

    static SubstitutionReasonEvent newSubstitutionReasonEvent(SubstitutionReason substitutionReason, SubstitutionReasonEvent.EventType eventType) {

        new SubstitutionReasonEvent(
            substitutionReason: substitutionReason,
            type: eventType,
            timestamp: new Date(),
            uuid: UUID.randomUUID()
        )
    }

    enum EventType {
        SAVED
    }
}
