package org.celllife.idart.domain.person


/**
 * Person Domain Event
 */
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
