package org.celllife.idart.interfaces.service.organisation

import org.celllife.idart.application.organisation.LegalOrganisationResourceService
import org.celllife.idart.domain.organisation.LegalOrganisation
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
@Controller class LegalOrganisationResourceController {

    @Autowired LegalOrganisationResourceService legalOrganisationResourceService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/legalOrganisations",
            method = RequestMethod.GET, produces = "application/json"
    )
    Iterable<LegalOrganisation> findAll() {
        legalOrganisationResourceService.findAll()
    }

    @ResponseBody
    @RequestMapping(
            value = "/legalOrganisations/{identifier}",
            method = RequestMethod.GET, produces = "application/json"
    )
    LegalOrganisation findByIdentifier(@PathVariable("identifier") String identifier) {
        legalOrganisationResourceService.findByIdentifier(identifier)
    }

    @RequestMapping(value = "/legalOrganisations", method = RequestMethod.POST)
    void save(@RequestBody LegalOrganisation legalOrganisation, HttpServletResponse response) {

        legalOrganisation = legalOrganisationResourceService.save(legalOrganisation)

        response.setHeader("Location", "${baseUrl}/legalOrganisations/${legalOrganisation.pk}")
        response.setStatus(SC_CREATED)
    }
}
