package org.celllife.idart.interfaces.resource.part

import org.celllife.idart.application.part.dto.PartDto
import org.celllife.idart.common.PartId
import org.celllife.idart.common.PartType
import org.celllife.idart.domain.part.PartNotFoundException
import org.celllife.idart.domain.part.PartValidationException
import org.celllife.idart.security.part.PartSecurityAdapter
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

import javax.annotation.Generated
import javax.inject.Inject
import javax.servlet.http.HttpServletResponse
import java.security.Principal

import static javax.servlet.http.HttpServletResponse.*

/**
 */
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

    @ResponseBody
    @RequestMapping(value = "/parts/search/findByType", method = RequestMethod.GET, produces = "application/json")
    Set<PartDto> findByType(@RequestParam("type") PartType type, Principal principal) {

        return partSecurityAdapter.findByType(principal, type)
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
