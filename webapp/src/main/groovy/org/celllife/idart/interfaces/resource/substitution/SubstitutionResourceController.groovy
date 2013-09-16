package org.celllife.idart.interfaces.resource.substitution

import org.celllife.idart.common.SubstitutionCode
import org.celllife.idart.application.substitution.dto.SubstitutionDto
import org.celllife.idart.domain.substitution.SubstitutionNotFoundException
import org.celllife.idart.domain.substitution.SubstitutionValidationException
import org.celllife.idart.security.substitution.SubstitutionSecurityAdapter
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
@Controller class SubstitutionResourceController {

    @Inject SubstitutionSecurityAdapter substitutionSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/substitutions/{substitutionCode}", method = RequestMethod.GET, produces = "application/json")
    SubstitutionDto findBySubstitutionCode(@PathVariable("substitutionCode") SubstitutionCode substitutionCode,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            return substitutionSecurityAdapter.findBySubstitutionCode(principal, substitutionCode)

        } catch (SubstitutionNotFoundException ignore) {

            response.setStatus(SC_NOT_FOUND)

            return null
        }
    }

    @RequestMapping(value = "/substitutions", method = RequestMethod.POST)
    void save(@RequestBody SubstitutionDto substitutionDto, Principal principal, HttpServletResponse response) {

        try {

            SubstitutionCode substitutionCode = substitutionSecurityAdapter.save(principal, substitutionDto)

            response.setHeader("Location", "${baseUrl}/substitutions/${substitutionCode}")
            response.setStatus(SC_CREATED)

        } catch (SubstitutionValidationException e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
