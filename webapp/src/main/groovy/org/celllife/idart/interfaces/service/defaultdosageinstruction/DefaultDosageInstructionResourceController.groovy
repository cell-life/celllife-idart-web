package org.celllife.idart.interfaces.service.defaultdosageinstruction

import org.celllife.idart.application.defaultdosageinstruction.DefaultDosageInstructionResourceService
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstruction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

import javax.annotation.Generated
import javax.servlet.http.HttpServletResponse

import static javax.servlet.http.HttpServletResponse.SC_CREATED

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 01h42
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Controller class DefaultDosageInstructionResourceController {

    @Autowired DefaultDosageInstructionResourceService defaultDosageInstructionResourceService

    @Value('${external.base.url}') String baseUrl

    @RequestMapping(value = "/defaultDosageInstructions", method = RequestMethod.POST)
    void save(@RequestBody DefaultDosageInstruction defaultDosageInstruction, HttpServletResponse response) {

        defaultDosageInstruction = defaultDosageInstructionResourceService.save(defaultDosageInstruction)

        response.setHeader("Location", "${baseUrl}/service/defaultDosageInstructions/${defaultDosageInstruction.pk}")
        response.setStatus(SC_CREATED)
    }
}
