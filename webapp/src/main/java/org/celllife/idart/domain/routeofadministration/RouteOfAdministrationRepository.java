package org.celllife.idart.domain.routeofadministration;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 17h50
 */
@RestResource(path = "routes")
interface RouteOfAdministrationRepository extends PagingAndSortingRepository<RouteOfAdministration, Long> {

    @Query("select routeOfAdministration " +
            "from RouteOfAdministration routeOfAdministration " +
            "join routeOfAdministration.codes code " +
            "where code.system = :system " +
            "and code.value = :code")
    RouteOfAdministration findOneBySystemAndCode(@Param("system") String system, @Param("code") String code);

}
