package org.celllife.idart.domain.system

import org.celllife.idart.common.EventHeader

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-10
 * Time: 12h28
 */
class SystemEventFactory {

    SystemEvent systemEvent

    SystemEventFactory() {
        this.systemEvent = new SystemEvent()
        this.systemEvent.header = new EventHeader()
        this.systemEvent.header.timestamp = new Date()
        this.systemEvent.header.uuid = UUID.randomUUID().toString()
    }

    SystemEventFactory username(String username) {
        this.systemEvent.header.username = username
        return this
    }

    SystemEventFactory system(System system) {
        this.systemEvent.system = system
        return this
    }

    SystemEvent systemEvent() {
        return systemEvent
    }
}
