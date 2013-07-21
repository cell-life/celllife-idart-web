package org.celllife.idart.domain.routeofadministration

import org.celllife.idart.domain.common.Code

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface RouteOfAdministrationService {

    Iterable<RouteOfAdministration> save(Iterable<RouteOfAdministration> routesOfAdministration)

    RouteOfAdministration save(RouteOfAdministration routeOfAdministration)

    Iterable<RouteOfAdministration> findAll()

    RouteOfAdministration findByCode(String code)

    RouteOfAdministration findByCodes(Iterable<Code> codes)

}