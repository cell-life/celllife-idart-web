package org.celllife.idart.interfaces.resource.entrysite

import org.celllife.idart.application.entrysite.EntrySiteApplicationService
import org.celllife.idart.domain.entrysite.EntrySite
import org.celllife.idart.domain.entrysite.EntrySiteCode
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
@Controller class EntrySiteResourceController {

    @Autowired EntrySiteApplicationService entrySiteApplicationService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/entrySites/{code}",
            method = RequestMethod.GET, produces = "application/json"
    )
    EntrySite findByCode(@PathVariable("code") EntrySiteCode code) {
        entrySiteApplicationService.findByCode(code)
    }

    @RequestMapping(value = "/entrySites", method = RequestMethod.POST)
    void save(@RequestBody EntrySite entrySite, HttpServletResponse response) {

        entrySite = entrySiteApplicationService.save(entrySite)

        response.setHeader("Location", "${baseUrl}/entrySites/${entrySite.code}")
        response.setStatus(SC_CREATED)
    }
}
