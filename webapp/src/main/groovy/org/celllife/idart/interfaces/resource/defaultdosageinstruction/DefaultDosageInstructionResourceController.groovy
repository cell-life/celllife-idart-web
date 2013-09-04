package org.celllife.idart.interfaces.resource.defaultdosageinstruction

import org.celllife.idart.common.DefaultDosageInstructionId
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstruction
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionNotFoundException
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionValidationException
import org.celllife.idart.security.defaultdosageinstruction.DefaultDosageInstructionSecurityAdapter
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
@Controller class DefaultDosageInstructionResourceController {

    @Inject DefaultDosageInstructionSecurityAdapter defaultDosageInstructionSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/defaultDosageInstructions/{defaultDosageInstructionId}", method = GET, produces = "application/json")
    DefaultDosageInstruction findByDefaultDosageInstructionId(@PathVariable("defaultDosageInstructionId") DefaultDosageInstructionId defaultDosageInstructionId,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            defaultDosageInstructionSecurityAdapter.findByDefaultDosageInstructionId(principal, defaultDosageInstructionId)

        } catch (DefaultDosageInstructionNotFoundException e) {
            response.setStatus(SC_NOT_FOUND)
        }
    }

    @RequestMapping(value = "/defaultDosageInstructions", method = POST)
    void save(@RequestBody DefaultDosageInstruction defaultDosageInstruction, Principal principal, HttpServletResponse response) {

        try {

            defaultDosageInstruction = defaultDosageInstructionSecurityAdapter.save(principal, defaultDosageInstruction)

            response.setHeader("Location", "${baseUrl}/defaultDosageInstructions/${defaultDosageInstruction.id}")
            response.setStatus(SC_CREATED)

        } catch (DefaultDosageInstructionValidationException e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
