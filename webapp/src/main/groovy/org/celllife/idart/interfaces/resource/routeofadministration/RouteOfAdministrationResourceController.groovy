package org.celllife.idart.interfaces.resource.routeofadministration

import org.celllife.idart.application.routeofadministration.RouteOfAdministrationApplicationService
import org.celllife.idart.domain.routeofadministration.RouteOfAdministration
import org.celllife.idart.common.RouteOfAdministrationCode
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

import javax.annotation.Generated
import javax.servlet.http.HttpServletResponse

import static javax.servlet.http.HttpServletResponse.SC_CREATED

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Controller class RouteOfAdministrationResourceController {

    @Autowired RouteOfAdministrationApplicationService routeOfAdministrationApplicationService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/routesOfAdministration/{routeOfAdministrationCode}",
            method = RequestMethod.GET, produces = "application/json"
    )
    RouteOfAdministration findByRouteOfAdministrationCode(@PathVariable("routeOfAdministrationCode") RouteOfAdministrationCode routeOfAdministrationCode) {
        routeOfAdministrationApplicationService.findByRouteOfAdministrationCode(routeOfAdministrationCode)
    }

    @RequestMapping(value = "/routesOfAdministration", method = RequestMethod.POST)
    void save(@RequestBody RouteOfAdministration routeOfAdministration, HttpServletResponse response) {

        routeOfAdministration = routeOfAdministrationApplicationService.save(routeOfAdministration)

        response.setHeader("Location", "${baseUrl}/routeOfAdministrations/${routeOfAdministration.code}")
        response.setStatus(SC_CREATED)
    }
}
