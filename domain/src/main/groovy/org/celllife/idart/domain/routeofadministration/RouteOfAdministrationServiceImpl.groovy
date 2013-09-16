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
    Boolean exists(RouteOfAdministrationCode routeOfAdministrationCode) {
        routeOfAdministrationRepository.exists(routeOfAdministrationCode)
    }

    @Override
    RouteOfAdministration save(RouteOfAdministration routeOfAdministration) {

        def existingRouteOfAdministration = routeOfAdministrationRepository.findOne(routeOfAdministration.id)

        if (existingRouteOfAdministration == null) {
            existingRouteOfAdministration = routeOfAdministration
        } else {
            existingRouteOfAdministration.merge(routeOfAdministration)
        }

        routeOfAdministrationValidator.validate(existingRouteOfAdministration)

        routeOfAdministrationEventPublisher.publish(newRouteOfAdministrationEvent(existingRouteOfAdministration, SAVED))

        routeOfAdministrationRepository.save(existingRouteOfAdministration)
    }

    @Override
    RouteOfAdministration findByRouteOfAdministrationCode(RouteOfAdministrationCode routeOfAdministrationCode) {

        def routeOfAdministration = routeOfAdministrationRepository.findOne(routeOfAdministrationCode)

        if (routeOfAdministration == null) {
            throw new RouteOfAdministrationNotFoundException("Could not find RouteOfAdministration with code [${ routeOfAdministrationCode}]")
        }

        routeOfAdministration
    }
}
