package org.celllife.idart.domain.routeofadministration

import javax.annotation.Generated

/**
 * Route Of Administration Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class RouteOfAdministrationEvent implements Serializable {

    Date timestamp

    UUID uuid

    EventType type

    String username

    RouteOfAdministration routeOfAdministration

    static RouteOfAdministrationEvent newRouteOfAdministrationEvent(RouteOfAdministration routeOfAdministration, RouteOfAdministrationEvent.EventType eventType) {

        new RouteOfAdministrationEvent(
            routeOfAdministration: routeOfAdministration,
            type: eventType,
            timestamp: new Date(),
            uuid: UUID.randomUUID()
        )
    }

    enum EventType {
        SAVED
    }
}
