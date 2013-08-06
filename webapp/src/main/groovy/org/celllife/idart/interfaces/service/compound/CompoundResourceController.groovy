package org.celllife.idart.interfaces.service.compound

import org.celllife.idart.application.compound.CompoundResourceService
import org.celllife.idart.domain.compound.Compound
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
@Controller class CompoundResourceController {

    @Autowired CompoundResourceService compoundResourceService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/compounds",
            method = RequestMethod.GET, produces = "application/json"
    )
    Iterable<Compound> findAll() {
        compoundResourceService.findAll()
    }

    @ResponseBody
    @RequestMapping(
            value = "/compounds/{identifier}",
            method = RequestMethod.GET, produces = "application/json"
    )
    Compound findByIdentifier(@PathVariable("identifier") String identifier) {
        compoundResourceService.findByIdentifier(identifier)
    }

    @RequestMapping(value = "/compounds", method = RequestMethod.POST)
    void save(@RequestBody Compound compound, HttpServletResponse response) {

        compound = compoundResourceService.save(compound)

        response.setHeader("Location", "${baseUrl}/compounds/${compound.pk}")
        response.setStatus(SC_CREATED)
    }
}
