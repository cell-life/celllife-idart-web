package org.celllife.idart.domain.routeofadministration;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-21
 * Time: 20h01
 */
public interface RouteOfAdministrationService {

    void save(Iterable<RouteOfAdministration> routeOfAdministrations);

    void save(RouteOfAdministration routeOfAdministration);

}
