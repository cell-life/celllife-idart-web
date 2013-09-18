package org.celllife.idart.domain.substitution

import javax.annotation.Generated

/**
 * Substitution Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class SubstitutionEvent implements Serializable {

    Date timestamp

    UUID uuid

    EventType type

    String username

    Substitution substitution

    static SubstitutionEvent newSubstitutionEvent(Substitution substitution, SubstitutionEvent.EventType eventType) {

        new SubstitutionEvent(
            substitution: substitution,
            type: eventType,
            timestamp: new Date(),
            uuid: UUID.randomUUID()
        )
    }

    enum EventType {
        SAVED
    }
}
