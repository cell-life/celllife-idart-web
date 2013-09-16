package org.celllife.idart.domain.user

import org.celllife.idart.common.EventHeader

import static org.celllife.idart.common.EventHeader.newEventHeader

import javax.annotation.Generated

/**
 * User Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class UserEvent implements Serializable {

    EventHeader header

    User user

    static UserEvent newUserEvent(User user, UserEvent.EventType eventType) {
        new UserEvent(user: user, header: newEventHeader(eventType))
    }

    enum EventType implements org.celllife.idart.common.EventType {
        SAVED
    }
}
