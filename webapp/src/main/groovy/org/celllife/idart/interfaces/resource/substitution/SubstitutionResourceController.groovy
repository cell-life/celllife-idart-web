package org.celllife.idart.interfaces.resource.substitution

import org.celllife.idart.common.SubstitutionCode
import org.celllife.idart.domain.substitution.Substitution
import org.celllife.idart.domain.substitution.SubstitutionNotFoundException
import org.celllife.idart.domain.substitution.SubstitutionValidationException
import org.celllife.idart.security.substitution.SubstitutionSecurityAdapter
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
@Controller class SubstitutionResourceController {

    @Inject SubstitutionSecurityAdapter substitutionSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/substitutions/{substitutionCode}", method = GET, produces = "application/json")
    Substitution findBySubstitutionCode(@PathVariable("substitutionCode") SubstitutionCode substitutionCode,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            substitutionSecurityAdapter.findBySubstitutionCode(principal, substitutionCode)

        } catch (SubstitutionNotFoundException e) {
            response.setStatus(SC_NOT_FOUND)
        }
    }

    @RequestMapping(value = "/substitutions", method = POST)
    void save(@RequestBody Substitution substitution, Principal principal, HttpServletResponse response) {

        try {

            substitution = substitutionSecurityAdapter.save(principal, substitution)

            response.setHeader("Location", "${baseUrl}/substitutions/${substitution.code}")
            response.setStatus(SC_CREATED)

        } catch (SubstitutionValidationException e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
