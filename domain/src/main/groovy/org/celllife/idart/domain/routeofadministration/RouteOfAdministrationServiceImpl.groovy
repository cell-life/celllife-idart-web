package org.celllife.idart.domain.routeofadministration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 03h45
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class RouteOfAdministrationServiceImpl implements RouteOfAdministrationService {

    @Autowired RouteOfAdministrationRepository routeOfAdministrationRepository

    @Override
    Iterable<RouteOfAdministration> save(Iterable<RouteOfAdministration> routesOfAdministration) {
        routesOfAdministration.collect { routeOfAdministration -> (save(routeOfAdministration)) }
    }

    @Override
    RouteOfAdministration save(RouteOfAdministration routeOfAdministration) {

        String system = routeOfAdministration.getFirstSystem()
        String code = routeOfAdministration.getCodeValue(system)

        RouteOfAdministration savedRouteOfAdministration = routeOfAdministrationRepository.findOneByCode(system, code)

        if (savedRouteOfAdministration != null) {
            savedRouteOfAdministration.mergeCodes(routeOfAdministration)
            return routeOfAdministrationRepository.save(savedRouteOfAdministration)
        } else {
            return routeOfAdministrationRepository.save(routeOfAdministration)
        }
    }              
    
    @Override
    Iterable<RouteOfAdministration> findAll() {
        routeOfAdministrationRepository.findAll()
    }

    @Override
    RouteOfAdministration findByIdentifier(String identifier) {
        null
    }
}