package org.celllife.idart.application.routeofadministration

import org.celllife.idart.domain.routeofadministration.RouteOfAdministration
import org.celllife.idart.domain.routeofadministration.RouteOfAdministrationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 01h28
 */
@Service
@Mixin(RouteOfAdministrationApplicationServiceMixin)
class RouteOfAdministrationApplicationServiceImpl implements RouteOfAdministrationApplicationService, RouteOfAdministrationResourceService {

    @Autowired RouteOfAdministrationService routeOfAdministrationService

    RouteOfAdministration save(RouteOfAdministration routeOfAdministration) {
        routeOfAdministrationService.save(routeOfAdministration)
    }

    RouteOfAdministration findByCode(String code) {
        routeOfAdministrationService.findByIdentifier(code)
    }

    Iterable<RouteOfAdministration> findAll() {
        routeOfAdministrationService.findAll()
    }

}