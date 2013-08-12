package org.celllife.idart.domain.systemfacility

import org.celllife.idart.common.EventHeader

import javax.annotation.Generated

import static org.celllife.idart.common.EventHeader.newEventHeader

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-10
 * Time: 12h28
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class SystemFacilityEvent {

    EventHeader header

    SystemFacility systemFacility

    static SystemFacilityEvent newSystemFacilityEvent(SystemFacility systemFacility,
                                                      SystemFacilityEvent.EventType eventType) {

        new SystemFacilityEvent(systemFacility: systemFacility, header: newEventHeader(eventType))
    }

    enum EventType implements org.celllife.idart.common.EventType {
        SAVED
    }

}
