package org.celllife.idart.domain.routeofadministration

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface RouteOfAdministrationRepository {

    RouteOfAdministration save(RouteOfAdministration routeOfAdministration)

    RouteOfAdministration findOne(RouteOfAdministrationCode code)

}
