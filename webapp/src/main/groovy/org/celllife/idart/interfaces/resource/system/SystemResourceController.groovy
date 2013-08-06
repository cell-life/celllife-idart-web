package org.celllife.idart.interfaces.resource.system

import org.celllife.idart.application.system.SystemApplicationService
import org.celllife.idart.domain.system.System
import org.celllife.idart.domain.system.SystemIdentifier
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
@Controller class SystemResourceController {

    @Autowired SystemApplicationService systemApplicationService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/systems/{identifier}",
            method = RequestMethod.GET, produces = "application/json"
    )
    System findByIdentifier(@PathVariable("identifier") SystemIdentifier identifier) {
        systemApplicationService.findByIdentifier(identifier)
    }

    @RequestMapping(value = "/systems", method = RequestMethod.POST)
    void save(@RequestBody System system, HttpServletResponse response) {

        system = systemApplicationService.save(system)

        response.setHeader("Location", "${baseUrl}/systems/${system.identifier}")
        response.setStatus(SC_CREATED)
    }
}
