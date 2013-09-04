package org.celllife.idart.domain.routeofadministration

import org.celllife.idart.common.RouteOfAdministrationCode

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.domain.routeofadministration.RouteOfAdministrationEvent.EventType.SAVED
import static org.celllife.idart.domain.routeofadministration.RouteOfAdministrationEvent.newRouteOfAdministrationEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class RouteOfAdministrationServiceImpl implements RouteOfAdministrationService {

    @Inject RouteOfAdministrationRepository routeOfAdministrationRepository

    @Inject RouteOfAdministrationValidator routeOfAdministrationValidator

    @Inject RouteOfAdministrationEventPublisher routeOfAdministrationEventPublisher

    @Override
    RouteOfAdministration save(RouteOfAdministration routeOfAdministration) {

        routeOfAdministrationValidator.validate(routeOfAdministration)

        routeOfAdministrationEventPublisher.publish(newRouteOfAdministrationEvent(routeOfAdministration, SAVED))

        routeOfAdministrationRepository.save(routeOfAdministration)
    }

    @Override
    RouteOfAdministration findByRouteOfAdministrationCode(RouteOfAdministrationCode routeOfAdministrationCode) {

        def routeOfAdministration = routeOfAdministrationRepository.findOne(routeOfAdministrationCode)

        if (routeOfAdministration == null) {
            throw new RouteOfAdministrationNotFoundException("Could not find RouteOfAdministration with Route Of Administration Code [${ routeOfAdministrationCode}]")
        }

        routeOfAdministration
    }
}
