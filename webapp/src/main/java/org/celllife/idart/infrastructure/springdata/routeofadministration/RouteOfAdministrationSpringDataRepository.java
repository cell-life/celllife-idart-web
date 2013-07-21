package org.celllife.idart.domain.routeofadministration;

import org.springframework.data.repository.CrudRepository;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 03h19
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface RouteOfAdministrationSpringDataRepository extends CrudRepository<RouteOfAdministration, Long> {

    RouteOfAdministration findOneByCode(String system, String code);

}
