package org.celllife.idart.interfaces.resource.indication

import org.celllife.idart.common.IndicationCode
import org.celllife.idart.domain.indication.Indication
import org.celllife.idart.domain.indication.IndicationNotFoundException
import org.celllife.idart.domain.indication.IndicationValidationException
import org.celllife.idart.security.indication.IndicationSecurityAdapter
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
@Controller class IndicationResourceController {

    @Inject IndicationSecurityAdapter indicationSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/indications/{indicationCode}", method = GET, produces = "application/json")
    Indication findByIndicationCode(@PathVariable("indicationCode") IndicationCode indicationCode,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            indicationSecurityAdapter.findByIndicationCode(principal, indicationCode)

        } catch (IndicationNotFoundException e) {
            response.setStatus(SC_NOT_FOUND)
        }
    }

    @RequestMapping(value = "/indications", method = POST)
    void save(@RequestBody Indication indication, Principal principal, HttpServletResponse response) {

        try {

            indication = indicationSecurityAdapter.save(principal, indication)

            response.setHeader("Location", "${baseUrl}/indications/${indication.code}")
            response.setStatus(SC_CREATED)

        } catch (IndicationValidationException e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
