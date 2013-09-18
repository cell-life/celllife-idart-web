package org.celllife.idart.domain.organisation


/**
 * Organisation Domain Event
 */
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
