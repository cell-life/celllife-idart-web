package org.celllife.idart.interfaces.resource.substitution

import org.celllife.idart.application.substitution.SubstitutionApplicationService
import org.celllife.idart.domain.substitution.Substitution
import org.celllife.idart.common.SubstitutionCode
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
@Controller class SubstitutionResourceController {

    @Autowired SubstitutionApplicationService substitutionApplicationService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/substitutions/{substitutionCode}",
            method = RequestMethod.GET, produces = "application/json"
    )
    Substitution findBySubstitutionCode(@PathVariable("substitutionCode") SubstitutionCode substitutionCode) {
        substitutionApplicationService.findBySubstitutionCode(substitutionCode)
    }

    @RequestMapping(value = "/substitutions", method = RequestMethod.POST)
    void save(@RequestBody Substitution substitution, HttpServletResponse response) {

        substitution = substitutionApplicationService.save(substitution)

        response.setHeader("Location", "${baseUrl}/substitutions/${substitution.code}")
        response.setStatus(SC_CREATED)
    }
}
