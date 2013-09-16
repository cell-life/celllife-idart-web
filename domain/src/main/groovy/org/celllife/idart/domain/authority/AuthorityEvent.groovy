package org.celllife.idart.domain.authority

import org.celllife.idart.common.EventHeader

import static org.celllife.idart.common.EventHeader.newEventHeader

import javax.annotation.Generated

/**
 * Authority Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class AuthorityEvent implements Serializable {

    EventHeader header

    Authority authority

    static AuthorityEvent newAuthorityEvent(Authority authority, AuthorityEvent.EventType eventType) {
        new AuthorityEvent(authority: authority, header: newEventHeader(eventType))
    }

    enum EventType implements org.celllife.idart.common.EventType {
        SAVED
    }
}
