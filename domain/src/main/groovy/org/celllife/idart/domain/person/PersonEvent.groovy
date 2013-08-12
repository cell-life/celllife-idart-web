package org.celllife.idart.domain.person

import org.celllife.idart.common.EventHeader
import org.celllife.idart.common.EventType

import static org.celllife.idart.common.EventHeader.newEventHeader

import javax.annotation.Generated

/**
 * Person Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PersonEvent {

    EventHeader header

    Person person

    static PersonEvent newPersonEvent(Person person, PersonEvent.EventType eventType) {
        new PersonEvent(person: person, header: newEventHeader(eventType))
    }

    enum EventType implements org.celllife.idart.common.EventType {
        SAVED
    }
}
