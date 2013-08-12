package org.celllife.idart.interfaces.resource.form

import org.celllife.idart.application.form.FormApplicationService
import org.celllife.idart.domain.form.Form
import org.celllife.idart.common.FormCode
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
@Controller class FormResourceController {

    @Autowired FormApplicationService formApplicationService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/forms/{formCode}",
            method = RequestMethod.GET, produces = "application/json"
    )
    Form findByFormCode(@PathVariable("formCode") FormCode formCode) {
        formApplicationService.findByFormCode(formCode)
    }

    @RequestMapping(value = "/forms", method = RequestMethod.POST)
    void save(@RequestBody Form form, HttpServletResponse response) {

        form = formApplicationService.save(form)

        response.setHeader("Location", "${baseUrl}/forms/${form.code}")
        response.setStatus(SC_CREATED)
    }
}
