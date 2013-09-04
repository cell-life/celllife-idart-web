package org.celllife.idart.interfaces.resource.form

import org.celllife.idart.common.FormCode
import org.celllife.idart.domain.form.Form
import org.celllife.idart.domain.form.FormNotFoundException
import org.celllife.idart.domain.form.FormValidationException
import org.celllife.idart.security.form.FormSecurityAdapter
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
@Controller class FormResourceController {

    @Inject FormSecurityAdapter formSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/forms/{formCode}", method = GET, produces = "application/json")
    Form findByFormCode(@PathVariable("formCode") FormCode formCode,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            formSecurityAdapter.findByFormCode(principal, formCode)

        } catch (FormNotFoundException e) {
            response.setStatus(SC_NOT_FOUND)
        }
    }

    @RequestMapping(value = "/forms", method = POST)
    void save(@RequestBody Form form, Principal principal, HttpServletResponse response) {

        try {

            form = formSecurityAdapter.save(principal, form)

            response.setHeader("Location", "${baseUrl}/forms/${form.code}")
            response.setStatus(SC_CREATED)

        } catch (FormValidationException e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
