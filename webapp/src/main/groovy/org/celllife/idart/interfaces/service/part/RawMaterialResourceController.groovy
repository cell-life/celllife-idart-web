package org.celllife.idart.interfaces.service.part

import org.celllife.idart.application.part.RawMaterialResourceService
import org.celllife.idart.domain.part.RawMaterial
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
 * Time: 22h33
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Controller class RawMaterialResourceController {

    @Autowired RawMaterialResourceService rawMaterialResourceService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/rawMaterials",
            method = RequestMethod.GET, produces = "application/json"
    )
    Iterable<RawMaterial> findAll(@RequestHeader("X-IDART_APPLICATION_ID") String applicationId) {
        rawMaterialResourceService.findAll()
    }

    @ResponseBody
    @RequestMapping(
            value = "/rawMaterials/{identifier}",
            method = RequestMethod.GET, produces = "application/json"
    )
    RawMaterial findByIdentifier(@PathVariable("coidentifierde") String identifier, @RequestHeader("X-IDART_APPLICATION_ID") String applicationId) {
        rawMaterialResourceService.findByIdentifier(identifier)
    }

    @RequestMapping(value = "/rawMaterials", method = RequestMethod.POST)
    void save(@RequestBody RawMaterial rawMaterial, HttpServletResponse response) {

        rawMaterial = rawMaterialResourceService.save(rawMaterial)

        response.setHeader("Location", "${baseUrl}/service/rawMaterials/${rawMaterial.pk}")
        response.setStatus(SC_CREATED)
    }
}
