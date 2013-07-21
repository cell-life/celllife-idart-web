package org.celllife.idart.interfaces.service.part

import org.celllife.idart.application.part.SubassemblyResourceService
import org.celllife.idart.domain.part.Subassembly
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
@Controller class SubassemblyResourceController {

    @Autowired SubassemblyResourceService subassemblyResourceService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/subassemblys",
            method = RequestMethod.GET, produces = "application/json"
    )
    Iterable<Subassembly> findAll(@RequestHeader("X-IDART_APPLICATION_ID") String applicationId) {
        subassemblyResourceService.findAll()
    }

    @ResponseBody
    @RequestMapping(
            value = "/subassemblys/{identifier}",
            method = RequestMethod.GET, produces = "application/json"
    )
    Subassembly findByIdentifier(@PathVariable("coidentifierde") String identifier, @RequestHeader("X-IDART_APPLICATION_ID") String applicationId) {
        subassemblyResourceService.findByIdentifier(identifier)
    }

    @RequestMapping(value = "/subassemblys", method = RequestMethod.POST)
    void save(@RequestBody Subassembly subassembly, HttpServletResponse response) {

        subassembly = subassemblyResourceService.save(subassembly)

        response.setHeader("Location", "${baseUrl}/service/subassemblys/${subassembly.pk}")
        response.setStatus(SC_CREATED)
    }
}
