package org.celllife.idart.interfaces.resource.authority

import org.celllife.idart.common.AuthorityId
import org.celllife.idart.application.authority.dto.AuthorityDto
import org.celllife.idart.domain.authority.AuthorityNotFoundException
import org.celllife.idart.domain.authority.AuthorityValidationException
import org.celllife.idart.security.authority.AuthoritySecurityAdapter
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
@Controller class AuthorityResourceController {

    @Inject AuthoritySecurityAdapter authoritySecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/authorities/{authorityId}", method = RequestMethod.GET, produces = "application/json")
    AuthorityDto findByAuthorityId(@PathVariable("authorityId") AuthorityId authorityId,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            return authoritySecurityAdapter.findByAuthorityId(principal, authorityId)

        } catch (AuthorityNotFoundException ignore) {

            response.setStatus(SC_NOT_FOUND)

            return null
        }
    }

    @RequestMapping(value = "/authorities", method = RequestMethod.POST)
    void save(@RequestBody AuthorityDto authorityDto, Principal principal, HttpServletResponse response) {

        try {

            AuthorityId authorityId = authoritySecurityAdapter.save(principal, authorityDto)

            response.setHeader("Location", "${baseUrl}/authorities/${authorityId}")
            response.setStatus(SC_CREATED)

        } catch (AuthorityValidationException e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
