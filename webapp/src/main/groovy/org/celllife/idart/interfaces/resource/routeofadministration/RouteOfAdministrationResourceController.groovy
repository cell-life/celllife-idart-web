package org.celllife.idart.interfaces.resource.routeofadministration

import org.celllife.idart.common.RouteOfAdministrationCode
import org.celllife.idart.domain.routeofadministration.RouteOfAdministration
import org.celllife.idart.domain.routeofadministration.RouteOfAdministrationNotFoundException
import org.celllife.idart.domain.routeofadministration.RouteOfAdministrationValidationException
import org.celllife.idart.security.routeofadministration.RouteOfAdministrationSecurityAdapter
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

import javax.annotation.Generated
import javax.inject.Inject
import javax.servlet.http.HttpServletResponse
import java.security.Principal

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST
import static javax.servlet.http.HttpServletResponse.SC_CREATED
import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND
import static org.springframework.web.bind.annotation.RequestMethod.GET
import static org.springframework.web.bind.annotation.RequestMethod.POST

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Controller class RouteOfAdministrationResourceController {

    @Inject RouteOfAdministrationSecurityAdapter routeOfAdministrationSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/routesOfAdministration/{routeOfAdministrationCode}", method = GET, produces = "application/json")
    RouteOfAdministration findByRouteOfAdministrationCode(@PathVariable("routeOfAdministrationCode") RouteOfAdministrationCode routeOfAdministrationCode,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            routeOfAdministrationSecurityAdapter.findByRouteOfAdministrationCode(principal, routeOfAdministrationCode)

        } catch (RouteOfAdministrationNotFoundException e) {
            response.setStatus(SC_NOT_FOUND)
        }
    }

    @RequestMapping(value = "/routesOfAdministration", method = POST)
    void save(@RequestBody RouteOfAdministration routeOfAdministration, Principal principal, HttpServletResponse response) {

        try {

            routeOfAdministration = routeOfAdministrationSecurityAdapter.save(principal, routeOfAdministration)

            response.setHeader("Location", "${baseUrl}/routeOfAdministrations/${routeOfAdministration.code}")
            response.setStatus(SC_CREATED)

        } catch (RouteOfAdministrationValidationException e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
