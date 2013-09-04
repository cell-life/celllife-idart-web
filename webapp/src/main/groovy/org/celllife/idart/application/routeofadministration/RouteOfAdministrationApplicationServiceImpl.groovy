package org.celllife.idart.application.routeofadministration

import org.celllife.idart.common.RouteOfAdministrationCode
import org.celllife.idart.domain.routeofadministration.RouteOfAdministration
import org.celllife.idart.domain.routeofadministration.RouteOfAdministrationService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class RouteOfAdministrationApplicationServiceImpl implements RouteOfAdministrationApplicationService {

    @Inject RouteOfAdministrationService routeOfAdministrationService

    RouteOfAdministration save(RouteOfAdministration routeOfAdministration) {
        routeOfAdministrationService.save(routeOfAdministration)
    }

    RouteOfAdministration findByRouteOfAdministrationCode(RouteOfAdministrationCode routeOfAdministrationCode) {
        routeOfAdministrationService.findByRouteOfAdministrationCode(routeOfAdministrationCode)
    }

}
