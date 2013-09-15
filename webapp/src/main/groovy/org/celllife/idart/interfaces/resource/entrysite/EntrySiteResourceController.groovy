package org.celllife.idart.interfaces.resource.entrysite

import org.celllife.idart.common.EntrySiteCode
import org.celllife.idart.application.entrysite.dto.EntrySiteDto
import org.celllife.idart.domain.entrysite.EntrySiteNotFoundException
import org.celllife.idart.domain.entrysite.EntrySiteValidationException
import org.celllife.idart.security.entrysite.EntrySiteSecurityAdapter
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
@Controller class EntrySiteResourceController {

    @Inject EntrySiteSecurityAdapter entrySiteSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/entrySites/{entrySiteCode}", method = RequestMethod.GET, produces = "application/json")
    EntrySiteDto findByEntrySiteCode(@PathVariable("entrySiteCode") EntrySiteCode entrySiteCode,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            return entrySiteSecurityAdapter.findByEntrySiteCode(principal, entrySiteCode)

        } catch (EntrySiteNotFoundException ignore) {

            response.setStatus(SC_NOT_FOUND)

            return null
        }
    }

    @RequestMapping(value = "/entrySites", method = RequestMethod.POST)
    void save(@RequestBody EntrySiteDto entrySiteDto, Principal principal, HttpServletResponse response) {

        try {

            EntrySiteCode entrySiteCode = entrySiteSecurityAdapter.save(principal, entrySiteDto)

            response.setHeader("Location", "${baseUrl}/entrySitess/${entrySiteCode}")
            response.setStatus(SC_CREATED)

        } catch (EntrySiteValidationException e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
