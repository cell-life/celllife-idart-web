package org.celllife.idart.infrastructure.springdata.routeofadministration;

import org.celllife.idart.domain.routeofadministration.RouteOfAdministration;
import org.celllife.idart.domain.routeofadministration.RouteOfAdministrationCode;
import org.celllife.idart.domain.routeofadministration.RouteOfAdministrationRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SpringDataRouteOfAdministrationRepository extends PagingAndSortingRepository<RouteOfAdministration, RouteOfAdministrationCode>, RouteOfAdministrationRepository {

}
