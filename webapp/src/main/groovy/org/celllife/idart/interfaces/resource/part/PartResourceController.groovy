package org.celllife.idart.interfaces.resource.part

import org.celllife.idart.common.PartId
import org.celllife.idart.application.part.dto.PartDto
import org.celllife.idart.domain.part.PartNotFoundException
import org.celllife.idart.domain.part.PartValidationException
import org.celllife.idart.security.part.PartSecurityAdapter
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
@Controller class PartResourceController {

    @Inject PartSecurityAdapter partSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/parts/{partId}", method = RequestMethod.GET, produces = "application/json")
    PartDto findByPartId(@PathVariable("partId") PartId partId,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            return partSecurityAdapter.findByPartId(principal, partId)

        } catch (PartNotFoundException ignore) {

            response.setStatus(SC_NOT_FOUND)

            return null
        }
    }

    @RequestMapping(value = "/parts", method = RequestMethod.POST)
    void save(@RequestBody PartDto partDto, Principal principal, HttpServletResponse response) {

        try {

            PartId partId = partSecurityAdapter.save(principal, partDto)

            response.setHeader("Location", "${baseUrl}/parts/${partId}")
            response.setStatus(SC_CREATED)

        } catch (PartValidationException e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
