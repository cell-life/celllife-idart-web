package org.celllife.idart.common

import org.springframework.security.core.userdetails.User

import static org.springframework.security.core.context.SecurityContextHolder.getContext

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-10
 * Time: 12h34
 */
class EventHeader {

    Date timestamp

    UUID uuid

    EventType type

    String username

    static EventHeader newEventHeader(EventType type) {

        EventHeader header = new EventHeader()
        header.type = type
        header.timestamp = new Date()
        header.uuid = UUID.randomUUID()
        header.username = ((User) context.authentication?.principal)?.username

        header
    }
}
