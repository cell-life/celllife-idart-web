package org.celllife.idart.interfaces.resource.substitutionreason

import org.celllife.idart.common.SubstitutionReasonCode
import org.celllife.idart.application.substitutionreason.dto.SubstitutionReasonDto
import org.celllife.idart.domain.substitutionreason.SubstitutionReasonNotFoundException
import org.celllife.idart.domain.substitutionreason.SubstitutionReasonValidationException
import org.celllife.idart.security.substitutionreason.SubstitutionReasonSecurityAdapter
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
@Controller class SubstitutionReasonResourceController {

    @Inject SubstitutionReasonSecurityAdapter substitutionReasonSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/substitutionReasons/{substitutionReasonCode}", method = RequestMethod.GET, produces = "application/json")
    SubstitutionReasonDto findBySubstitutionReasonCode(@PathVariable("substitutionReasonCode") SubstitutionReasonCode substitutionReasonCode,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            return substitutionReasonSecurityAdapter.findBySubstitutionReasonCode(principal, substitutionReasonCode)

        } catch (SubstitutionReasonNotFoundException ignore) {

            response.setStatus(SC_NOT_FOUND)

            return null
        }
    }

    @RequestMapping(value = "/substitutionReasons", method = RequestMethod.POST)
    void save(@RequestBody SubstitutionReasonDto substitutionReasonDto, Principal principal, HttpServletResponse response) {

        try {

            SubstitutionReasonCode substitutionReasonCode = substitutionReasonSecurityAdapter.save(principal, substitutionReasonDto)

            response.setHeader("Location", "${baseUrl}/substitutionReasons/${substitutionReasonCode}")
            response.setStatus(SC_CREATED)

        } catch (SubstitutionReasonValidationException e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
