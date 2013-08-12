package org.celllife.idart.interfaces.resource.defaultdosageinstruction

import org.celllife.idart.application.defaultdosageinstruction.DefaultDosageInstructionApplicationService
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstruction
import org.celllife.idart.common.DefaultDosageInstructionIdentifier
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
@Controller class DefaultDosageInstructionResourceController {

    @Autowired DefaultDosageInstructionApplicationService defaultDosageInstructionApplicationService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(
            value = "/defaultDosageInstructions/{defaultDosageInstructionIdentifier}",
            method = RequestMethod.GET, produces = "application/json"
    )
    DefaultDosageInstruction findByDefaultDosageInstructionIdentifier(@PathVariable("defaultDosageInstructionIdentifier") DefaultDosageInstructionIdentifier defaultDosageInstructionIdentifier) {
        defaultDosageInstructionApplicationService.findByDefaultDosageInstructionIdentifier(defaultDosageInstructionIdentifier)
    }

    @RequestMapping(value = "/defaultDosageInstructions", method = RequestMethod.POST)
    void save(@RequestBody DefaultDosageInstruction defaultDosageInstruction, HttpServletResponse response) {

        defaultDosageInstruction = defaultDosageInstructionApplicationService.save(defaultDosageInstruction)

        response.setHeader("Location", "${baseUrl}/defaultDosageInstructions/${defaultDosageInstruction.identifier}")
        response.setStatus(SC_CREATED)
    }
}
