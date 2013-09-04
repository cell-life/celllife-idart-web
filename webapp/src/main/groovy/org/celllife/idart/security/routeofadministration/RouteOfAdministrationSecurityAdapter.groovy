package org.celllife.idart.security.routeofadministration

import org.celllife.idart.common.RouteOfAdministrationCode
import org.celllife.idart.domain.routeofadministration.RouteOfAdministration
import org.celllife.idart.application.routeofadministration.RouteOfAdministrationApplicationService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class RouteOfAdministrationSecurityAdapter {

    @Inject RouteOfAdministrationApplicationService routeOfAdministrationApplicationService

    RouteOfAdministration save(Principal principal, RouteOfAdministration routeOfAdministration) {
        routeOfAdministrationApplicationService.save(routeOfAdministration)
    }

    RouteOfAdministration findByRouteOfAdministrationCode(Principal principal, RouteOfAdministrationCode routeOfAdministrationCode) {
        routeOfAdministrationApplicationService.findByRouteOfAdministrationCode(routeOfAdministrationCode)
    }

}
