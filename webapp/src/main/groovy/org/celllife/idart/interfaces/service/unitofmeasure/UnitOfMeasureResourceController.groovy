package org.celllife.idart.interfaces.service.unitofmeasure

import org.celllife.idart.application.unitofmeasure.UnitOfMeasureResourceService
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure
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
@Controller class UnitOfMeasureResourceController {

    @Autowired UnitOfMeasureResourceService unitOfMeasureResourceService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/unitsOfMeasure",
            method = RequestMethod.GET, produces = "application/json"
    )
    Iterable<UnitOfMeasure> findAll(@RequestHeader("X-IDART_APPLICATION_ID") String applicationId) {
        unitOfMeasureResourceService.findAll()
    }

    @ResponseBody
    @RequestMapping(
            value = "/unitsOfMeasure/{code}",
            method = RequestMethod.GET, produces = "application/json"
    )
    UnitOfMeasure findByCode(@PathVariable("code") String code, @RequestHeader("X-IDART_APPLICATION_ID") String applicationId) {
        unitOfMeasureResourceService.findByCode(code)
    }

    @RequestMapping(value = "/unitsOfMeasure", method = RequestMethod.POST)
    void save(@RequestBody UnitOfMeasure unitOfMeasure, HttpServletResponse response) {

        unitOfMeasure = unitOfMeasureResourceService.save(unitOfMeasure)

        response.setHeader("Location", "${baseUrl}/service/unitOfMeasures/${unitOfMeasure.pk}")
        response.setStatus(SC_CREATED)
    }
}