package org.celllife.idart.domain.routeofadministration

import org.celllife.idart.common.EventHeader
import org.celllife.idart.common.EventType

import static org.celllife.idart.common.EventHeader.newEventHeader

import javax.annotation.Generated

/**
 * Route Of Administration Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class RouteOfAdministrationEvent {

    EventHeader header

    RouteOfAdministration routeOfAdministration

    static RouteOfAdministrationEvent newRouteOfAdministrationEvent(RouteOfAdministration routeOfAdministration, RouteOfAdministrationEvent.EventType eventType) {
        new RouteOfAdministrationEvent(routeOfAdministration: routeOfAdministration, header: newEventHeader(eventType))
    }

    enum EventType implements org.celllife.idart.common.EventType {
        SAVED
    }
}
