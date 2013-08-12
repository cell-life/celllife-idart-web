package org.celllife.idart.interfaces.resource.legalorganisation

import org.celllife.idart.application.legalorganisation.LegalOrganisationApplicationService
import org.celllife.idart.domain.legalorganisation.LegalOrganisation
import org.celllife.idart.common.PartyIdentifier
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

    @Autowired LegalOrganisationApplicationService legalOrganisationApplicationService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/legalOrganisations/{partyIdentifier}",
            method = RequestMethod.GET, produces = "application/json"
    )
    LegalOrganisation findByPartyIdentifier(@PathVariable("partyIdentifier") PartyIdentifier partyIdentifier) {
        legalOrganisationApplicationService.findByPartyIdentifier(partyIdentifier)
    }

    @RequestMapping(value = "/legalOrganisations", method = RequestMethod.POST)
    void save(@RequestBody LegalOrganisation legalOrganisation, HttpServletResponse response) {

        legalOrganisation = legalOrganisationApplicationService.save(legalOrganisation)

        response.setHeader("Location", "${baseUrl}/legalOrganisations/${legalOrganisation.identifier}")
        response.setStatus(SC_CREATED)
    }
}
