package org.celllife.idart.domain.administrationmethod

import org.celllife.idart.common.EventHeader

import static org.celllife.idart.common.EventHeader.newEventHeader

import javax.annotation.Generated

/**
 * Administration Method Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class AdministrationMethodEvent implements Serializable {

    EventHeader header

    AdministrationMethod administrationMethod

    static AdministrationMethodEvent newAdministrationMethodEvent(AdministrationMethod administrationMethod, AdministrationMethodEvent.EventType eventType) {
        new AdministrationMethodEvent(administrationMethod: administrationMethod, header: newEventHeader(eventType))
    }

    enum EventType implements org.celllife.idart.common.EventType {
        SAVED
    }
}
