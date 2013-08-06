package org.celllife.idart.interfaces.resource.unitofmeasuretype

import org.celllife.idart.application.unitofmeasuretype.UnitOfMeasureTypeApplicationService
import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureType
import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureTypeCode
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
@Controller class UnitOfMeasureTypeResourceController {

    @Autowired UnitOfMeasureTypeApplicationService unitOfMeasureTypeApplicationService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/unitOfMeasureTypes/{code}",
            method = RequestMethod.GET, produces = "application/json"
    )
    UnitOfMeasureType findByCode(@PathVariable("code") UnitOfMeasureTypeCode code) {
        unitOfMeasureTypeApplicationService.findByCode(code)
    }

    @RequestMapping(value = "/unitOfMeasureTypes", method = RequestMethod.POST)
    void save(@RequestBody UnitOfMeasureType unitOfMeasureType, HttpServletResponse response) {

        unitOfMeasureType = unitOfMeasureTypeApplicationService.save(unitOfMeasureType)

        response.setHeader("Location", "${baseUrl}/unitOfMeasureTypes/${unitOfMeasureType.code}")
        response.setStatus(SC_CREATED)
    }
}
