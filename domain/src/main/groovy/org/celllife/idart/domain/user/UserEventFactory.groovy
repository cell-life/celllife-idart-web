package org.celllife.idart.domain.user

import org.celllife.idart.domain.common.EventHeader

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-10
 * Time: 12h28
 */
class UserEventFactory {

    UserEvent userEvent

    UserEventFactory() {
        this.userEvent = new UserEvent()
        this.userEvent.header = new EventHeader()
        this.userEvent.header.timestamp = new Date()
        this.userEvent.header.uuid = UUID.randomUUID().toString()
    }

    UserEventFactory username(String username) {
        this.userEvent.header.username = username
        return this
    }

    UserEventFactory user(User user) {
        this.userEvent.user = user
        return this
    }

    UserEvent build() {
        return userEvent
    }
}
