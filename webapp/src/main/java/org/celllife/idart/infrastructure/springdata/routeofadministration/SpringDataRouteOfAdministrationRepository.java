package org.celllife.idart.infrastructure.springdata.routeofadministration;

import org.celllife.idart.common.RouteOfAdministrationCode;
import org.celllife.idart.domain.routeofadministration.RouteOfAdministration;
import org.celllife.idart.domain.routeofadministration.RouteOfAdministrationRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataRouteOfAdministrationRepository extends RouteOfAdministrationRepository,
        PagingAndSortingRepository<RouteOfAdministration, RouteOfAdministrationCode> {

}
