package org.celllife.idart.interfaces.resource.routeofadministration

import org.celllife.idart.common.RouteOfAdministrationCode
import org.celllife.idart.application.routeofadministration.dto.RouteOfAdministrationDto
import org.celllife.idart.domain.routeofadministration.RouteOfAdministrationNotFoundException
import org.celllife.idart.domain.routeofadministration.RouteOfAdministrationValidationException
import org.celllife.idart.security.routeofadministration.RouteOfAdministrationSecurityAdapter
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

import javax.annotation.Generated
import javax.inject.Inject
import javax.servlet.http.HttpServletResponse
import java.security.Principal

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST
import static javax.servlet.http.HttpServletResponse.SC_CREATED
import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Controller class RouteOfAdministrationResourceController {

    @Inject RouteOfAdministrationSecurityAdapter routeOfAdministrationSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/routesOfAdministration/{routeOfAdministrationCode}", method = RequestMethod.GET, produces = "application/json")
    RouteOfAdministrationDto findByRouteOfAdministrationCode(@PathVariable("routeOfAdministrationCode") RouteOfAdministrationCode routeOfAdministrationCode,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            return routeOfAdministrationSecurityAdapter.findByRouteOfAdministrationCode(principal, routeOfAdministrationCode)

        } catch (RouteOfAdministrationNotFoundException ignore) {

            response.setStatus(SC_NOT_FOUND)

            return null
        }
    }

    @RequestMapping(value = "/routesOfAdministration", method = RequestMethod.POST)
    void save(@RequestBody RouteOfAdministrationDto routeOfAdministrationDto, Principal principal, HttpServletResponse response) {

        try {

            RouteOfAdministrationCode routeOfAdministrationCode = routeOfAdministrationSecurityAdapter.save(principal, routeOfAdministrationDto)

            response.setHeader("Location", "${baseUrl}/routesOfAdministrations/${routeOfAdministrationCode}")
            response.setStatus(SC_CREATED)

        } catch (RouteOfAdministrationValidationException e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
