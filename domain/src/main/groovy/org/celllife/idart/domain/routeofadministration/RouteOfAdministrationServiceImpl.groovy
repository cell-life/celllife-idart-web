package org.celllife.idart.domain.routeofadministration

import org.celllife.idart.domain.common.Code

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
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
        routeOfAdministrationRepository.save(lookupAndMerge(routeOfAdministration))
    }

    def lookupAndMerge(RouteOfAdministration routeOfAdministration) {

        def (String system, String value) = getLookupCode(routeOfAdministration)

        RouteOfAdministration existingRouteOfAdministration = routeOfAdministrationRepository.findOneByCode(system, value)

        if (existingRouteOfAdministration == null) {

            // Ensure that idartCodeValue is always set
            if (routeOfAdministration.idartCodeValue == null) {
                routeOfAdministration.addCode(routeOfAdministration.idartSystem, routeOfAdministration.defaultCodeValue)
            }

            return routeOfAdministration
        }

        existingRouteOfAdministration.mergeCodes(routeOfAdministration)
        existingRouteOfAdministration
    }

    static getLookupCode(RouteOfAdministration routeOfAdministration) {

        if (routeOfAdministration.idartCodeValue == null && routeOfAdministration.defaultCodeValue == null) {
            throw new RuntimeException("No code for default system [${ routeOfAdministration.defaultSystem}] or idart system [${ routeOfAdministration.idartSystem}]")
        }

        if (routeOfAdministration.defaultCodeValue != null) {
            return [routeOfAdministration.defaultSystem, routeOfAdministration.defaultCodeValue]
        }

        return [routeOfAdministration.idartSystem, routeOfAdministration.idartCodeValue]
    }

    @Override
    Iterable<RouteOfAdministration> findAll() {
        routeOfAdministrationRepository.findAll()
    }

    @Override
    RouteOfAdministration findByCode(String code) {
        routeOfAdministrationRepository.findOneByCode(RouteOfAdministration.IDART_SYSTEM, code)
    }

    @Override
    RouteOfAdministration findByCodes(Iterable<Code> codes) {

        if (codes == null) {
            return null
        }

        for (code in codes) {
            def routeOfAdministration = routeOfAdministrationRepository.findOneByCode(code.system, code.value)
            if (routeOfAdministration != null) {
                return routeOfAdministration
            }
        }

        null
    }
}