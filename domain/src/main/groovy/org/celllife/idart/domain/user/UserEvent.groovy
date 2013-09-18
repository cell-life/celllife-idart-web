package org.celllife.idart.domain.user


/**
 * User Domain Event
 */
class UserEvent implements Serializable {

    Date timestamp

    UUID uuid

    EventType type

    String username

    User user

    static UserEvent newUserEvent(User user, UserEvent.EventType eventType) {

        new UserEvent(
            user: user,
            type: eventType,
            timestamp: new Date(),
            uuid: UUID.randomUUID()
        )
    }

    enum EventType {
        SAVED
    }
}
