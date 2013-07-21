package org.celllife.idart.interfaces.service.routeofadministration

import org.celllife.idart.application.routeofadministration.RouteOfAdministrationResourceService
import org.celllife.idart.domain.routeofadministration.RouteOfAdministration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

import javax.annotation.Generated
import javax.servlet.http.HttpServletResponse

import static javax.servlet.http.HttpServletResponse.SC_CREATED

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 02h48
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Controller class RouteOfAdministrationResourceController {

    @Autowired RouteOfAdministrationResourceService routeOfAdministrationResourceService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/routesOfAdministration",
            method = RequestMethod.GET, produces = "application/json"
    )
    Iterable<RouteOfAdministration> findAll(@RequestHeader("X-IDART_APPLICATION_ID") String applicationId) {
        routeOfAdministrationResourceService.findAll()
    }

    @ResponseBody
    @RequestMapping(
            value = "/routesOfAdministration/{code}",
            method = RequestMethod.GET, produces = "application/json"
    )
    RouteOfAdministration findByCode(@PathVariable("code") String code, @RequestHeader("X-IDART_APPLICATION_ID") String applicationId) {
        routeOfAdministrationResourceService.findByCode(code)
    }

    @RequestMapping(value = "/routesOfAdministration", method = RequestMethod.POST)
    void save(@RequestBody RouteOfAdministration routeOfAdministration, HttpServletResponse response) {

        routeOfAdministration = routeOfAdministrationResourceService.save(routeOfAdministration)

        response.setHeader("Location", "${baseUrl}/service/routeOfAdministrations/${routeOfAdministration.pk}")
        response.setStatus(SC_CREATED)
    }
}