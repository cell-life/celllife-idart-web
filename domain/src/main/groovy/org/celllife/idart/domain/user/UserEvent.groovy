package org.celllife.idart.domain.user

import org.celllife.idart.common.EventHeader
import org.celllife.idart.common.EventType

import static org.celllife.idart.common.EventHeader.newEventHeader

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-10
 * Time: 12h28
 */
class UserEvent {

    EventHeader header

    User user

    static UserEvent newUserEvent(User user, UserEventType userEventType) {
        new UserEvent(user: user, header: newEventHeader(userEventType))
    }

    enum UserEventType implements EventType {
        SAVED
    }
}
