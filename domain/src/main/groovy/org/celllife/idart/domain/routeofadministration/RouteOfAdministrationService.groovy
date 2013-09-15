package org.celllife.idart.domain.routeofadministration

import org.celllife.idart.common.RouteOfAdministrationCode

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface RouteOfAdministrationService {

    Boolean exists(RouteOfAdministrationCode routeOfAdministrationCode)

    RouteOfAdministration save(RouteOfAdministration routeOfAdministration)

    RouteOfAdministration findByRouteOfAdministrationCode(RouteOfAdministrationCode routeOfAdministrationCode)

}
