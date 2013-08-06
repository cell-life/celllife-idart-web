package org.celllife.idart.domain.routeofadministration

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface RouteOfAdministrationService {

    RouteOfAdministration save(RouteOfAdministration routeOfAdministration) throws RouteOfAdministrationValidationException

    RouteOfAdministration findByCode(RouteOfAdministrationCode code) throws RouteOfAdministrationNotFoundException

}