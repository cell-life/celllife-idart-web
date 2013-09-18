package org.celllife.idart.domain.user

import javax.annotation.Generated

/**
 * User Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
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
