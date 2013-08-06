package org.celllife.idart.interfaces.resource.administrationmethod

import org.celllife.idart.application.administrationmethod.AdministrationMethodApplicationService
import org.celllife.idart.domain.administrationmethod.AdministrationMethod
import org.celllife.idart.domain.administrationmethod.AdministrationMethodCode
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
@Controller class AdministrationMethodResourceController {

    @Autowired AdministrationMethodApplicationService administrationMethodApplicationService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/administrationMethods/{code}",
            method = RequestMethod.GET, produces = "application/json"
    )
    AdministrationMethod findByCode(@PathVariable("code") AdministrationMethodCode code) {
        administrationMethodApplicationService.findByCode(code)
    }

    @RequestMapping(value = "/administrationMethods", method = RequestMethod.POST)
    void save(@RequestBody AdministrationMethod administrationMethod, HttpServletResponse response) {

        administrationMethod = administrationMethodApplicationService.save(administrationMethod)

        response.setHeader("Location", "${baseUrl}/administrationMethods/${administrationMethod.code}")
        response.setStatus(SC_CREATED)
    }
}
