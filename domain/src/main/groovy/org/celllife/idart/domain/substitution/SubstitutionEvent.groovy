package org.celllife.idart.domain.substitution

import org.celllife.idart.common.EventHeader

import static org.celllife.idart.common.EventHeader.newEventHeader

import javax.annotation.Generated

/**
 * Substitution Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class SubstitutionEvent implements Serializable {

    EventHeader header

    Substitution substitution

    static SubstitutionEvent newSubstitutionEvent(Substitution substitution, SubstitutionEvent.EventType eventType) {
        new SubstitutionEvent(substitution: substitution, header: newEventHeader(eventType))
    }

    enum EventType implements org.celllife.idart.common.EventType {
        SAVED
    }
}
