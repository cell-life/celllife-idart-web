package org.celllife.idart.domain.routeofadministration;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 20h35
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface RouteOfAdministrationRepository {

    // RouteOfAdministration save(RouteOfAdministration routeOfAdministration);

    // Iterable<RouteOfAdministration> save(Iterable<RouteOfAdministration> routesOfAdministration);

    // RouteOfAdministration findOne(Long pk);

    // Iterable<RouteOfAdministration> findAll();

    RouteOfAdministration findOneByCode(String system, String code);

}
