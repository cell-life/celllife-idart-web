package org.celllife.idart.interfaces.resource.entrysite

import org.celllife.idart.common.EntrySiteCode
import org.celllife.idart.domain.entrysite.EntrySite
import org.celllife.idart.domain.entrysite.EntrySiteNotFoundException
import org.celllife.idart.domain.entrysite.EntrySiteValidationException
import org.celllife.idart.security.entrysite.EntrySiteSecurityAdapter
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
@Controller class EntrySiteResourceController {

    @Inject EntrySiteSecurityAdapter entrySiteSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/entrySites/{entrySiteCode}", method = GET, produces = "application/json")
    EntrySite findByEntrySiteCode(@PathVariable("entrySiteCode") EntrySiteCode entrySiteCode,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            entrySiteSecurityAdapter.findByEntrySiteCode(principal, entrySiteCode)

        } catch (EntrySiteNotFoundException e) {
            response.setStatus(SC_NOT_FOUND)
        }
    }

    @RequestMapping(value = "/entrySites", method = POST)
    void save(@RequestBody EntrySite entrySite, Principal principal, HttpServletResponse response) {

        try {

            entrySite = entrySiteSecurityAdapter.save(principal, entrySite)

            response.setHeader("Location", "${baseUrl}/entrySites/${entrySite.code}")
            response.setStatus(SC_CREATED)

        } catch (EntrySiteValidationException e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
