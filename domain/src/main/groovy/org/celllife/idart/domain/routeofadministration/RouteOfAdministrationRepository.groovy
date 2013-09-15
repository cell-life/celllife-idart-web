package org.celllife.idart.domain.routeofadministration

import org.celllife.idart.common.RouteOfAdministrationCode

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface RouteOfAdministrationRepository {

    boolean exists(RouteOfAdministrationCode routeOfAdministrationCode)

    RouteOfAdministration save(RouteOfAdministration routeOfAdministration)

    RouteOfAdministration findOne(RouteOfAdministrationCode routeOfAdministrationCode)

}
