package org.celllife.idart.domain.routeofadministration

import org.celllife.idart.common.RouteOfAdministrationCode

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

import static org.celllife.idart.domain.routeofadministration.RouteOfAdministrationEvent.EventType.SAVED
import static org.celllife.idart.domain.routeofadministration.RouteOfAdministrationEvent.newRouteOfAdministrationEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class RouteOfAdministrationServiceImpl implements RouteOfAdministrationService {

    @Autowired RouteOfAdministrationRepository routeOfAdministrationRepository

    @Autowired RouteOfAdministrationValidator routeOfAdministrationValidator

    @Autowired RouteOfAdministrationEventPublisher routeOfAdministrationEventPublisher

    @Override
    RouteOfAdministration save(RouteOfAdministration routeOfAdministration) throws RouteOfAdministrationValidationException {

        routeOfAdministrationValidator.validate(routeOfAdministration)

        routeOfAdministrationEventPublisher.publish(newRouteOfAdministrationEvent(routeOfAdministration, SAVED))

        routeOfAdministrationRepository.save(routeOfAdministration)
    }

    @Override
    RouteOfAdministration findByRouteOfAdministrationCode(RouteOfAdministrationCode routeOfAdministrationCode) throws RouteOfAdministrationNotFoundException {

        def routeOfAdministration = routeOfAdministrationRepository.findOne(routeOfAdministrationCode)

        if (routeOfAdministration == null) {
            throw new RouteOfAdministrationNotFoundException("Could not find RouteOfAdministration with Route Of Administration Code [${ routeOfAdministrationCode}]")
        }

        routeOfAdministration
    }
}