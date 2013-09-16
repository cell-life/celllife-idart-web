package org.celllife.idart.domain.person

import org.celllife.idart.common.EventHeader

import static org.celllife.idart.common.EventHeader.newEventHeader

import javax.annotation.Generated

/**
 * Person Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PersonEvent implements Serializable {

    EventHeader header

    Person person

    static PersonEvent newPersonEvent(Person person, PersonEvent.EventType eventType) {
        new PersonEvent(person: person, header: newEventHeader(eventType))
    }

    enum EventType implements org.celllife.idart.common.EventType {
        SAVED
    }
}
