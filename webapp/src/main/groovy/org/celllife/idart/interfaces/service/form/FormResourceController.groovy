package org.celllife.idart.interfaces.service.form

import org.celllife.idart.application.form.FormResourceService
import org.celllife.idart.domain.form.Form
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

import javax.annotation.Generated
import javax.servlet.http.HttpServletResponse

import static javax.servlet.http.HttpServletResponse.SC_CREATED

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 02h48
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Controller class FormResourceController {

    @Autowired FormResourceService formResourceService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/forms",
            method = RequestMethod.GET, produces = "application/json"
    )
    Iterable<Form> findAll(@RequestHeader("X-IDART_APPLICATION_ID") String applicationId) {
        formResourceService.findAll()
    }

    @ResponseBody
    @RequestMapping(
            value = "/forms/{code}",
            method = RequestMethod.GET, produces = "application/json"
    )
    Form findByCode(@PathVariable("code") String code, @RequestHeader("X-IDART_APPLICATION_ID") String applicationId) {
        formResourceService.findByCode(code)
    }

    @RequestMapping(value = "/forms", method = RequestMethod.POST)
    void save(@RequestBody Form form, HttpServletResponse response) {

        form = formResourceService.save(form)

        response.setHeader("Location", "${baseUrl}/service/forms/${form.pk}")
        response.setStatus(SC_CREATED)
    }
}
