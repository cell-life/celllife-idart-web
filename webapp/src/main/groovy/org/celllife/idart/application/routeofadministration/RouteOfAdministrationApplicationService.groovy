package org.celllife.idart.application.routeofadministration

import org.celllife.idart.domain.routeofadministration.RouteOfAdministration
import org.celllife.idart.domain.routeofadministration.RouteOfAdministrationValidationException
import org.celllife.idart.domain.routeofadministration.RouteOfAdministrationNotFoundException
import org.celllife.idart.common.RouteOfAdministrationCode

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface RouteOfAdministrationApplicationService {

    RouteOfAdministration save(RouteOfAdministration routeOfAdministration) throws RouteOfAdministrationValidationException

    RouteOfAdministration findByRouteOfAdministrationCode(RouteOfAdministrationCode routeOfAdministrationCode) throws RouteOfAdministrationNotFoundException

}
