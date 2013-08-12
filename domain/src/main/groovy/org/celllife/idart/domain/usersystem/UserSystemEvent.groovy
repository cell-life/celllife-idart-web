package org.celllife.idart.domain.usersystem

import org.celllife.idart.common.EventHeader

import javax.annotation.Generated

import static org.celllife.idart.common.EventHeader.newEventHeader

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-10
 * Time: 12h28
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class UserSystemEvent {

    EventHeader header

    UserSystem userSystem

    static UserSystemEvent newUserSystemEvent(UserSystem userSystem, UserSystemEvent.EventType eventType) {
        new UserSystemEvent(userSystem: userSystem, header: newEventHeader(eventType))
    }

    enum EventType implements org.celllife.idart.common.EventType {
        SAVED
    }

}
