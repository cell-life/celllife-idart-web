package org.celllife.idart.interfaces.resource.administrationmethod

import org.celllife.idart.common.AdministrationMethodCode
import org.celllife.idart.application.administrationmethod.dto.AdministrationMethodDto
import org.celllife.idart.domain.administrationmethod.AdministrationMethodNotFoundException
import org.celllife.idart.domain.administrationmethod.AdministrationMethodValidationException
import org.celllife.idart.security.administrationmethod.AdministrationMethodSecurityAdapter
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
@Controller class AdministrationMethodResourceController {

    @Inject AdministrationMethodSecurityAdapter administrationMethodSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/administrationMethods/{administrationMethodCode}", method = RequestMethod.GET, produces = "application/json")
    AdministrationMethodDto findByAdministrationMethodCode(@PathVariable("administrationMethodCode") AdministrationMethodCode administrationMethodCode,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            return administrationMethodSecurityAdapter.findByAdministrationMethodCode(principal, administrationMethodCode)

        } catch (AdministrationMethodNotFoundException ignore) {

            response.setStatus(SC_NOT_FOUND)

            return null
        }
    }

    @RequestMapping(value = "/administrationMethods", method = RequestMethod.POST)
    void save(@RequestBody AdministrationMethodDto administrationMethodDto, Principal principal, HttpServletResponse response) {

        try {

            AdministrationMethodCode administrationMethodCode = administrationMethodSecurityAdapter.save(principal, administrationMethodDto)

            response.setHeader("Location", "${baseUrl}/administrationMethodss/${administrationMethodCode}")
            response.setStatus(SC_CREATED)

        } catch (AdministrationMethodValidationException e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
