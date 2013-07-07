package org.celllife.idart.domain.routeofadministration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-21
 * Time: 20h01
 */
@Service class RouteOfAdministrationServiceImpl implements RouteOfAdministrationService {

    @Autowired RouteOfAdministrationRepository routeOfAdministrationRespository

    def save(Iterable<RouteOfAdministration> routeOfAdministrations) {
        routeOfAdministrations.each { routeOfAdministration -> save(routeOfAdministration) }
    }

    def save(RouteOfAdministration routeOfAdministration) {

        String system = routeOfAdministration.getFirstSystem()
        String code = routeOfAdministration.getCodeValue(system)

        RouteOfAdministration savedRouteOfAdministration =
            routeOfAdministrationRespository.findOneBySystemAndCode(system, code)

        if (savedRouteOfAdministration != null) {
            savedRouteOfAdministration.mergeCodes(routeOfAdministration)
            routeOfAdministrationRespository.save(savedRouteOfAdministration)
        } else {
            routeOfAdministrationRespository.save(routeOfAdministration)
        }
    }
}
