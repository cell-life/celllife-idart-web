package org.celllife.idart.interfaces.service.system

import org.celllife.idart.application.system.SystemResourceService
import org.celllife.idart.domain.system.System
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

import javax.annotation.Generated
import javax.servlet.http.HttpServletResponse

import static javax.servlet.http.HttpServletResponse.SC_CREATED

/**
 * Generated by org.celllife.idart.codegen.CodeGenerator
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Controller class SystemResourceController {

    @Autowired SystemResourceService systemResourceService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/systems",
            method = RequestMethod.GET, produces = "application/json"
    )
    Iterable<System> findAll() {
        systemResourceService.findAll()
    }

    @ResponseBody
    @RequestMapping(
            value = "/systems/{identifier}",
            method = RequestMethod.GET, produces = "application/json"
    )
    System findByIdentifier(@PathVariable("identifier") String identifier) {
        systemResourceService.findByIdentifier(identifier)
    }

    @RequestMapping(value = "/systems", method = RequestMethod.POST)
    void save(@RequestBody System system, HttpServletResponse response) {

        system = systemResourceService.save(system)

        response.setHeader("Location", "${baseUrl}/systems/${system.identifier}")
        response.setStatus(SC_CREATED)
    }
}
