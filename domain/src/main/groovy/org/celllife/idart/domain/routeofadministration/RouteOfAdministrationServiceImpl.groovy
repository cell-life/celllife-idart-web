package org.celllife.idart.domain.routeofadministration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class RouteOfAdministrationServiceImpl implements RouteOfAdministrationService {

    @Autowired RouteOfAdministrationRepository routeOfAdministrationRepository

    @Autowired RouteOfAdministrationValidator routeOfAdministrationValidator

    @Override
    RouteOfAdministration save(RouteOfAdministration routeOfAdministration) throws RouteOfAdministrationValidationException {

        routeOfAdministrationValidator.validate(routeOfAdministration)

        routeOfAdministrationRepository.save(routeOfAdministration)
    }

    @Override
    RouteOfAdministration findByCode(RouteOfAdministrationCode code) throws RouteOfAdministrationNotFoundException {

        def routeOfAdministration = routeOfAdministrationRepository.findOne(code)

        if (routeOfAdministration == null) {
            throw new RouteOfAdministrationNotFoundException("Could not find RouteOfAdministration with Code [${ code}]")
        }

        routeOfAdministration
    }
}