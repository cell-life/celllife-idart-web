package org.celllife.idart.interfaces.resource.unitofmeasure

import org.celllife.idart.common.UnitOfMeasureCode
import org.celllife.idart.application.unitofmeasure.dto.UnitOfMeasureDto
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureNotFoundException
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureValidationException
import org.celllife.idart.security.unitofmeasure.UnitOfMeasureSecurityAdapter
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
@Controller class UnitOfMeasureResourceController {

    @Inject UnitOfMeasureSecurityAdapter unitOfMeasureSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/unitsOfMeasure/{unitOfMeasureCode}", method = RequestMethod.GET, produces = "application/json")
    UnitOfMeasureDto findByUnitOfMeasureCode(@PathVariable("unitOfMeasureCode") UnitOfMeasureCode unitOfMeasureCode,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            return unitOfMeasureSecurityAdapter.findByUnitOfMeasureCode(principal, unitOfMeasureCode)

        } catch (UnitOfMeasureNotFoundException ignore) {

            response.setStatus(SC_NOT_FOUND)

            return null
        }
    }

    @RequestMapping(value = "/unitsOfMeasure", method = RequestMethod.POST)
    void save(@RequestBody UnitOfMeasureDto unitOfMeasureDto, Principal principal, HttpServletResponse response) {

        try {

            UnitOfMeasureCode unitOfMeasureCode = unitOfMeasureSecurityAdapter.save(principal, unitOfMeasureDto)

            response.setHeader("Location", "${baseUrl}/unitsOfMeasures/${unitOfMeasureCode}")
            response.setStatus(SC_CREATED)

        } catch (UnitOfMeasureValidationException e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
