package org.celllife.idart.domain.organisation

import org.celllife.idart.common.EventHeader

import static org.celllife.idart.common.EventHeader.newEventHeader

import javax.annotation.Generated

/**
 * Organisation Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class OrganisationEvent implements Serializable {

    EventHeader header

    Organisation organisation

    static OrganisationEvent newOrganisationEvent(Organisation organisation, OrganisationEvent.EventType eventType) {
        new OrganisationEvent(organisation: organisation, header: newEventHeader(eventType))
    }

    enum EventType implements org.celllife.idart.common.EventType {
        SAVED
    }
}
