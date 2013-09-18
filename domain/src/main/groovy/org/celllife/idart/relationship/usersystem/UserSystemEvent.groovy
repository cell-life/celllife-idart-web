package org.celllife.idart.relationship.usersystem
/**
 * User: Kevin W. Sewell
 * Date: 2013-08-10
 * Time: 12h28
 */
class UserSystemEvent {

    Date timestamp

    UUID uuid

    EventType type

    String username

    UserSystem userSystem

    static UserSystemEvent newUserSystemEvent(UserSystem userSystem, UserSystemEvent.EventType eventType) {
        new UserSystemEvent(
                userSystem: userSystem,
                type: eventType,
                timestamp: new Date(),
                uuid: UUID.randomUUID()
        )
    }

    enum EventType implements org.celllife.idart.common.EventType {
        SAVED
    }

}
