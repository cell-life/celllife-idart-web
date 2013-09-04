package org.celllife.idart.interfaces.resource.authority

import org.celllife.idart.common.AuthorityId
import org.celllife.idart.domain.authority.Authority
import org.celllife.idart.domain.authority.AuthorityNotFoundException
import org.celllife.idart.domain.authority.AuthorityValidationException
import org.celllife.idart.security.authority.AuthoritySecurityAdapter
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
@Controller class AuthorityResourceController {

    @Inject AuthoritySecurityAdapter authoritySecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/authorities/{authorityId}", method = GET, produces = "application/json")
    Authority findByAuthorityId(@PathVariable("authorityId") AuthorityId authorityId,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            authoritySecurityAdapter.findByAuthorityId(principal, authorityId)

        } catch (AuthorityNotFoundException e) {
            response.setStatus(SC_NOT_FOUND)
        }
    }

    @RequestMapping(value = "/authorities", method = POST)
    void save(@RequestBody Authority authority, Principal principal, HttpServletResponse response) {

        try {

            authority = authoritySecurityAdapter.save(principal, authority)

            response.setHeader("Location", "${baseUrl}/authoritys/${authority.id}")
            response.setStatus(SC_CREATED)

        } catch (AuthorityValidationException e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
