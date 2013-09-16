package org.celllife.idart.interfaces.resource.organisation

import org.celllife.idart.common.OrganisationId
import org.celllife.idart.application.organisation.dto.OrganisationDto
import org.celllife.idart.domain.organisation.OrganisationNotFoundException
import org.celllife.idart.domain.organisation.OrganisationValidationException
import org.celllife.idart.security.organisation.OrganisationSecurityAdapter
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
@Controller class OrganisationResourceController {

    @Inject OrganisationSecurityAdapter organisationSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/organisations/{organisationId}", method = RequestMethod.GET, produces = "application/json")
    OrganisationDto findByOrganisationId(@PathVariable("organisationId") OrganisationId organisationId,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            return organisationSecurityAdapter.findByOrganisationId(principal, organisationId)

        } catch (OrganisationNotFoundException ignore) {

            response.setStatus(SC_NOT_FOUND)

            return null
        }
    }

    @RequestMapping(value = "/organisations", method = RequestMethod.POST)
    void save(@RequestBody OrganisationDto organisationDto, Principal principal, HttpServletResponse response) {

        try {

            OrganisationId organisationId = organisationSecurityAdapter.save(principal, organisationDto)

            response.setHeader("Location", "${baseUrl}/organisations/${organisationId}")
            response.setStatus(SC_CREATED)

        } catch (OrganisationValidationException e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
