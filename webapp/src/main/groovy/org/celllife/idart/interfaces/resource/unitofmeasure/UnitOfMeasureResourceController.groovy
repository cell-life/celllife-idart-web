package org.celllife.idart.interfaces.resource.unitofmeasure

import org.celllife.idart.application.unitofmeasure.UnitOfMeasureApplicationService
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureCode
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
@Controller class UnitOfMeasureResourceController {

    @Autowired UnitOfMeasureApplicationService unitOfMeasureApplicationService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/unitsOfMeasure/{code}",
            method = RequestMethod.GET, produces = "application/json"
    )
    UnitOfMeasure findByCode(@PathVariable("code") UnitOfMeasureCode code) {
        unitOfMeasureApplicationService.findByCode(code)
    }

    @RequestMapping(value = "/unitsOfMeasure", method = RequestMethod.POST)
    void save(@RequestBody UnitOfMeasure unitOfMeasure, HttpServletResponse response) {

        unitOfMeasure = unitOfMeasureApplicationService.save(unitOfMeasure)

        response.setHeader("Location", "${baseUrl}/unitOfMeasures/${unitOfMeasure.code}")
        response.setStatus(SC_CREATED)
    }
}
