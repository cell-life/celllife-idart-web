package org.celllife.idart.security.routeofadministration

import org.celllife.idart.application.routeofadministration.dto.RouteOfAdministrationDto
import org.celllife.idart.common.RouteOfAdministrationCode
import org.celllife.idart.common.Identifier
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

    RouteOfAdministrationCode save(Principal principal, routeOfAdministrationDto) {
        routeOfAdministrationApplicationService.save(routeOfAdministrationDto)
    }

    RouteOfAdministrationDto findByRouteOfAdministrationCode(Principal principal, RouteOfAdministrationCode routeOfAdministrationCode) {
        routeOfAdministrationApplicationService.findByRouteOfAdministrationCode(routeOfAdministrationCode)
    }

    RouteOfAdministrationDto findByIdentifier(Principal principal, Identifier identifier) {
        routeOfAdministrationApplicationService.findByIdentifier(identifier)
    }

}
