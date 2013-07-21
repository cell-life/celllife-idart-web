package org.celllife.idart.interfaces.service.administrationmethod

import org.celllife.idart.application.administrationmethod.AdministrationMethodResourceService
import org.celllife.idart.domain.administrationmethod.AdministrationMethod
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
 * Time: 20h36
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Controller class AdministrationMethodResourceController {

    @Autowired AdministrationMethodResourceService administrationMethodResourceService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/administrationMethods",
            method = RequestMethod.GET, produces = "application/json"
    )
    Iterable<AdministrationMethod> findAll(@RequestHeader("X-IDART_APPLICATION_ID") String applicationId) {
        administrationMethodResourceService.findAll()
    }

    @ResponseBody
    @RequestMapping(
            value = "/administrationMethods/{code}",
            method = RequestMethod.GET, produces = "application/json"
    )
    AdministrationMethod findByCode(@PathVariable("code") String code, @RequestHeader("X-IDART_APPLICATION_ID") String applicationId) {
        administrationMethodResourceService.findByCode(code)
    }

    @RequestMapping(value = "/administrationMethods", method = RequestMethod.POST)
    void save(@RequestBody AdministrationMethod administrationMethod, HttpServletResponse response) {

        administrationMethod = administrationMethodResourceService.save(administrationMethod)

        response.setHeader("Location", "${baseUrl}/service/administrationMethods/${administrationMethod.pk}")
        response.setStatus(SC_CREATED)
    }
}
