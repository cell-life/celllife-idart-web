package org.celllife.idart.relationship.usersystem

import org.celllife.idart.common.EventHeader

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-10
 * Time: 12h28
 */
class UserSystemEventFactory {

    UserSystemEvent userSystemEvent

    UserSystemEventFactory() {
        this.userSystemEvent = new UserSystemEvent()
        this.userSystemEvent.header = new EventHeader()
        this.userSystemEvent.header.timestamp = new Date()
        this.userSystemEvent.header.uuid = UUID.randomUUID().toString()
    }

    UserSystemEventFactory username(String username) {
        this.userSystemEvent.header.username = username
        return this
    }

    UserSystemEventFactory userSystem(UserSystem userSystem) {
        this.userSystemEvent.userSystem = userSystem
        return this
    }

    UserSystemEvent build() {
        return userSystemEvent
    }
}
