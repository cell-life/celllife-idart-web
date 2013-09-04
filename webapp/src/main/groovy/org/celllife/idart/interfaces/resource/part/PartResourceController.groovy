package org.celllife.idart.interfaces.resource.part

import org.celllife.idart.common.PartId
import org.celllife.idart.domain.part.Part
import org.celllife.idart.domain.part.PartNotFoundException
import org.celllife.idart.domain.part.PartValidationException
import org.celllife.idart.security.part.PartSecurityAdapter
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
@Controller class PartResourceController {

    @Inject PartSecurityAdapter partSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/parts/{partId}", method = GET, produces = "application/json")
    Part findByPartId(@PathVariable("partId") PartId partId,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            partSecurityAdapter.findByPartId(principal, partId)

        } catch (PartNotFoundException e) {
            response.setStatus(SC_NOT_FOUND)
        }
    }

    @RequestMapping(value = "/parts", method = POST)
    void save(@RequestBody Part part, Principal principal, HttpServletResponse response) {

        try {

            part = partSecurityAdapter.save(principal, part)

            response.setHeader("Location", "${baseUrl}/parts/${part.id}")
            response.setStatus(SC_CREATED)

        } catch (PartValidationException e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
