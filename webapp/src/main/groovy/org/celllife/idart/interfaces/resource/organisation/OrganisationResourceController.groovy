package org.celllife.idart.interfaces.resource.organisation

import org.celllife.idart.application.organisation.OrganisationApplicationService
import org.celllife.idart.domain.organisation.Organisation
import org.celllife.idart.common.OrganisationId
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
@Controller class OrganisationResourceController {

    @Autowired OrganisationApplicationService organisationApplicationService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/organisations/{organisationId}",
            method = RequestMethod.GET, produces = "application/json"
    )
    Organisation findByOrganisationId(@PathVariable("organisationId") OrganisationId organisationId) {
        organisationApplicationService.findByOrganisationId(organisationId)
    }

    @RequestMapping(value = "/organisations", method = RequestMethod.POST)
    void save(@RequestBody Organisation organisation, HttpServletResponse response) {

        organisation = organisationApplicationService.save(organisation)

        response.setHeader("Location", "${baseUrl}/organisations/${organisation.id}")
        response.setStatus(SC_CREATED)
    }
}
