package org.celllife.idart.domain.administrationmethod

import javax.annotation.Generated

/**
 * Administration Method Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class AdministrationMethodEvent implements Serializable {

    Date timestamp

    UUID uuid

    EventType type

    String username

    AdministrationMethod administrationMethod

    static AdministrationMethodEvent newAdministrationMethodEvent(AdministrationMethod administrationMethod, AdministrationMethodEvent.EventType eventType) {

        new AdministrationMethodEvent(
            administrationMethod: administrationMethod,
            type: eventType,
            timestamp: new Date(),
            uuid: UUID.randomUUID()
        )
    }

    enum EventType {
        SAVED
    }
}
