package org.celllife.idart.domain.organisation

import javax.annotation.Generated

/**
 * Organisation Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class OrganisationEvent implements Serializable {

    Date timestamp

    UUID uuid

    EventType type

    String username

    Organisation organisation

    static OrganisationEvent newOrganisationEvent(Organisation organisation, OrganisationEvent.EventType eventType) {

        new OrganisationEvent(
            organisation: organisation,
            type: eventType,
            timestamp: new Date(),
            uuid: UUID.randomUUID()
        )
    }

    enum EventType {
        SAVED
    }
}
