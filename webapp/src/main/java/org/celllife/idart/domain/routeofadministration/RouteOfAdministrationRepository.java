package org.celllife.idart.domain.routeofadministration;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 02h48
 */
@RestResource(path = "routesOfAdministration")
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface RouteOfAdministrationRepository extends PagingAndSortingRepository<RouteOfAdministration, Long> {

    @Query("select routeOfAdministration " +
            "from RouteOfAdministration routeOfAdministration " +
            "join routeOfAdministration.codes code " +
            "where code.system = :system " +
            "and code.value = :code")
    RouteOfAdministration findOneByCode(@Param("system") String system, @Param("code") String code);

}