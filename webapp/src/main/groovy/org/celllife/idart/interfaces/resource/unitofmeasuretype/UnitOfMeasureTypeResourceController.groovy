package org.celllife.idart.interfaces.resource.unitofmeasuretype

import org.celllife.idart.common.UnitOfMeasureTypeCode
import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureType
import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureTypeNotFoundException
import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureTypeValidationException
import org.celllife.idart.security.unitofmeasuretype.UnitOfMeasureTypeSecurityAdapter
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

import javax.annotation.Generated
import javax.inject.Inject
import javax.servlet.http.HttpServletResponse
import java.security.Principal

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST
import static javax.servlet.http.HttpServletResponse.SC_CREATED
import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND
import static org.springframework.web.bind.annotation.RequestMethod.GET
import static org.springframework.web.bind.annotation.RequestMethod.POST

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Controller class UnitOfMeasureTypeResourceController {

    @Inject UnitOfMeasureTypeSecurityAdapter unitOfMeasureTypeSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/unitOfMeasureTypes/{unitOfMeasureTypeCode}", method = GET, produces = "application/json")
    UnitOfMeasureType findByUnitOfMeasureTypeCode(@PathVariable("unitOfMeasureTypeCode") UnitOfMeasureTypeCode unitOfMeasureTypeCode,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            unitOfMeasureTypeSecurityAdapter.findByUnitOfMeasureTypeCode(principal, unitOfMeasureTypeCode)

        } catch (UnitOfMeasureTypeNotFoundException e) {
            response.setStatus(SC_NOT_FOUND)
        }
    }

    @RequestMapping(value = "/unitOfMeasureTypes", method = POST)
    void save(@RequestBody UnitOfMeasureType unitOfMeasureType, Principal principal, HttpServletResponse response) {

        try {

            unitOfMeasureType = unitOfMeasureTypeSecurityAdapter.save(principal, unitOfMeasureType)

            response.setHeader("Location", "${baseUrl}/unitOfMeasureTypes/${unitOfMeasureType.code}")
            response.setStatus(SC_CREATED)

        } catch (UnitOfMeasureTypeValidationException e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
