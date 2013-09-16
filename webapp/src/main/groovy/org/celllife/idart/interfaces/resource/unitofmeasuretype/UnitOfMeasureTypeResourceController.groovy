package org.celllife.idart.interfaces.resource.unitofmeasuretype

import org.celllife.idart.common.UnitOfMeasureTypeCode
import org.celllife.idart.application.unitofmeasuretype.dto.UnitOfMeasureTypeDto
import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureTypeNotFoundException
import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureTypeValidationException
import org.celllife.idart.security.unitofmeasuretype.UnitOfMeasureTypeSecurityAdapter
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

import javax.annotation.Generated
import javax.inject.Inject
import javax.servlet.http.HttpServletResponse
import java.security.Principal

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST
import static javax.servlet.http.HttpServletResponse.SC_CREATED
import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Controller class UnitOfMeasureTypeResourceController {

    @Inject UnitOfMeasureTypeSecurityAdapter unitOfMeasureTypeSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/unitOfMeasureTypes/{unitOfMeasureTypeCode}", method = RequestMethod.GET, produces = "application/json")
    UnitOfMeasureTypeDto findByUnitOfMeasureTypeCode(@PathVariable("unitOfMeasureTypeCode") UnitOfMeasureTypeCode unitOfMeasureTypeCode,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            return unitOfMeasureTypeSecurityAdapter.findByUnitOfMeasureTypeCode(principal, unitOfMeasureTypeCode)

        } catch (UnitOfMeasureTypeNotFoundException ignore) {

            response.setStatus(SC_NOT_FOUND)

            return null
        }
    }

    @RequestMapping(value = "/unitOfMeasureTypes", method = RequestMethod.POST)
    void save(@RequestBody UnitOfMeasureTypeDto unitOfMeasureTypeDto, Principal principal, HttpServletResponse response) {

        try {

            UnitOfMeasureTypeCode unitOfMeasureTypeCode = unitOfMeasureTypeSecurityAdapter.save(principal, unitOfMeasureTypeDto)

            response.setHeader("Location", "${baseUrl}/unitOfMeasureTypes/${unitOfMeasureTypeCode}")
            response.setStatus(SC_CREATED)

        } catch (UnitOfMeasureTypeValidationException e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
