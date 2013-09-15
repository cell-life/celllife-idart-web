package org.celllife.idart.interfaces.resource.indication

import org.celllife.idart.common.IndicationCode
import org.celllife.idart.application.indication.dto.IndicationDto
import org.celllife.idart.domain.indication.IndicationNotFoundException
import org.celllife.idart.domain.indication.IndicationValidationException
import org.celllife.idart.security.indication.IndicationSecurityAdapter
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
@Controller class IndicationResourceController {

    @Inject IndicationSecurityAdapter indicationSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/indications/{indicationCode}", method = RequestMethod.GET, produces = "application/json")
    IndicationDto findByIndicationCode(@PathVariable("indicationCode") IndicationCode indicationCode,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            return indicationSecurityAdapter.findByIndicationCode(principal, indicationCode)

        } catch (IndicationNotFoundException ignore) {

            response.setStatus(SC_NOT_FOUND)

            return null
        }
    }

    @RequestMapping(value = "/indications", method = RequestMethod.POST)
    void save(@RequestBody IndicationDto indicationDto, Principal principal, HttpServletResponse response) {

        try {

            IndicationCode indicationCode = indicationSecurityAdapter.save(principal, indicationDto)

            response.setHeader("Location", "${baseUrl}/indicationss/${indicationCode}")
            response.setStatus(SC_CREATED)

        } catch (IndicationValidationException e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
