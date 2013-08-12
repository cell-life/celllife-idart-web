package org.celllife.idart.interfaces.resource.substitutionreason

import org.celllife.idart.application.substitutionreason.SubstitutionReasonApplicationService
import org.celllife.idart.domain.substitutionreason.SubstitutionReason
import org.celllife.idart.common.SubstitutionReasonCode
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
@Controller class SubstitutionReasonResourceController {

    @Autowired SubstitutionReasonApplicationService substitutionReasonApplicationService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/substitutionReasons/{substitutionReasonCode}",
            method = RequestMethod.GET, produces = "application/json"
    )
    SubstitutionReason findBySubstitutionReasonCode(@PathVariable("substitutionReasonCode") SubstitutionReasonCode substitutionReasonCode) {
        substitutionReasonApplicationService.findBySubstitutionReasonCode(substitutionReasonCode)
    }

    @RequestMapping(value = "/substitutionReasons", method = RequestMethod.POST)
    void save(@RequestBody SubstitutionReason substitutionReason, HttpServletResponse response) {

        substitutionReason = substitutionReasonApplicationService.save(substitutionReason)

        response.setHeader("Location", "${baseUrl}/substitutionReasons/${substitutionReason.code}")
        response.setStatus(SC_CREATED)
    }
}
