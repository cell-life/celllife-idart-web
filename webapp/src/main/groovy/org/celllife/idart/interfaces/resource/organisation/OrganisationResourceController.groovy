package org.celllife.idart.interfaces.resource.organisation

import org.celllife.idart.common.OrganisationId
import org.celllife.idart.domain.organisation.Organisation
import org.celllife.idart.domain.organisation.OrganisationNotFoundException
import org.celllife.idart.domain.organisation.OrganisationValidationException
import org.celllife.idart.security.organisation.OrganisationSecurityAdapter
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
@Controller class OrganisationResourceController {

    @Inject OrganisationSecurityAdapter organisationSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/organisations/{organisationId}", method = GET, produces = "application/json")
    Organisation findByOrganisationId(@PathVariable("organisationId") OrganisationId organisationId,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            organisationSecurityAdapter.findByOrganisationId(principal, organisationId)

        } catch (OrganisationNotFoundException e) {
            response.setStatus(SC_NOT_FOUND)
        }
    }

    @RequestMapping(value = "/organisations", method = POST)
    void save(@RequestBody Organisation organisation, Principal principal, HttpServletResponse response) {

        try {

            organisation = organisationSecurityAdapter.save(principal, organisation)

            response.setHeader("Location", "${baseUrl}/organisations/${organisation.id}")
            response.setStatus(SC_CREATED)

        } catch (OrganisationValidationException e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
