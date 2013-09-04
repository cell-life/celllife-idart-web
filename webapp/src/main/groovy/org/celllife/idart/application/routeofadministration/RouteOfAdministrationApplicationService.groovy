package org.celllife.idart.application.routeofadministration

import org.celllife.idart.common.RouteOfAdministrationCode
import org.celllife.idart.domain.routeofadministration.RouteOfAdministration

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface RouteOfAdministrationApplicationService {

    RouteOfAdministration save(RouteOfAdministration routeOfAdministration)

    RouteOfAdministration findByRouteOfAdministrationCode(RouteOfAdministrationCode routeOfAdministrationCode)

}
