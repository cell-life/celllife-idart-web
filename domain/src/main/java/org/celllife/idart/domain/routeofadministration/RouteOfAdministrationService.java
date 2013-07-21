package org.celllife.idart.domain.routeofadministration;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 03h45
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface RouteOfAdministrationService {

    Iterable<RouteOfAdministration> save(Iterable<RouteOfAdministration> routesOfAdministration);

    RouteOfAdministration save(RouteOfAdministration routeOfAdministration);

    Iterable<RouteOfAdministration> findAll();

    RouteOfAdministration findByIdentifier(String identifier);

}