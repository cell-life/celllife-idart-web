package org.celllife.idart.application.routeofadministration

import org.celllife.idart.domain.routeofadministration.RouteOfAdministration
import org.celllife.idart.domain.routeofadministration.RouteOfAdministrationValidationException
import org.celllife.idart.domain.routeofadministration.RouteOfAdministrationNotFoundException
import org.celllife.idart.domain.routeofadministration.RouteOfAdministrationCode
import org.celllife.idart.domain.routeofadministration.RouteOfAdministrationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class RouteOfAdministrationApplicationServiceImpl implements RouteOfAdministrationApplicationService {

    @Autowired RouteOfAdministrationService routeOfAdministrationService

    RouteOfAdministration save(RouteOfAdministration routeOfAdministration) throws RouteOfAdministrationValidationException {
        routeOfAdministrationService.save(routeOfAdministration)
    }

    RouteOfAdministration findByCode(RouteOfAdministrationCode code) throws RouteOfAdministrationNotFoundException{
        routeOfAdministrationService.findByCode(code)
    }

}