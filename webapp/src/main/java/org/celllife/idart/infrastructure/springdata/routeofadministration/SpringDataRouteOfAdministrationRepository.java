package org.celllife.idart.infrastructure.springdata.routeofadministration;

import org.celllife.idart.domain.routeofadministration.RouteOfAdministration;
import org.celllife.idart.domain.routeofadministration.RouteOfAdministrationRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h33
 */
@RestResource(path = "routesOfAdministration")
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataRouteOfAdministrationRepository extends PagingAndSortingRepository<RouteOfAdministration, Long>, RouteOfAdministrationRepository {

    @Query("select routeOfAdministration " +
            "from RouteOfAdministration routeOfAdministration " +
            "join routeOfAdministration.codes code " +
            "where code.system = :system " +
            "and code.value = :code")
    RouteOfAdministration findOneByCode(@Param("system") String system, @Param("code") String code);

}
