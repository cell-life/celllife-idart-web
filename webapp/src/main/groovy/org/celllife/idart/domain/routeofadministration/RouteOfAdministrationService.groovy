package org.celllife.idart.domain.routeofadministration

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-21
 * Time: 20h01
 */
interface RouteOfAdministrationService {

    def save(Iterable<RouteOfAdministration> routeOfAdministrations)

    def save(RouteOfAdministration routeOfAdministration)

}
