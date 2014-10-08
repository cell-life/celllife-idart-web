package org.celllife.idart.domain.person

import groovy.transform.ToString


/**
 * Person Domain Event
 */
@ToString
class PersonEvent implements Serializable {

    Date timestamp

    UUID uuid

    EventType type

    String username

    Person person

    static PersonEvent newPersonEvent(Person person, PersonEvent.EventType eventType) {

        new PersonEvent(
            person: person,
            type: eventType,
            timestamp: new Date(),
            uuid: UUID.randomUUID()
        )
    }

    enum EventType {
        SAVED
    }
}
