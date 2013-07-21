package org.celllife.idart.application.routeofadministration;

import org.celllife.idart.domain.routeofadministration.RouteOfAdministration;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 02h48
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface RouteOfAdministrationResourceService {

    RouteOfAdministration save(RouteOfAdministration routeOfAdministration);

    RouteOfAdministration findByCode(String code);

    Iterable<RouteOfAdministration> findAll();

}