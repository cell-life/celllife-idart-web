package org.celllife.idart.interfaces.resource.defaultdosageinstruction

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST
import static javax.servlet.http.HttpServletResponse.SC_CREATED
import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND

import java.security.Principal

import javax.inject.Inject
import javax.servlet.http.HttpServletResponse

import org.celllife.idart.application.defaultdosageinstruction.dto.DefaultDosageInstructionDto
import org.celllife.idart.common.DefaultDosageInstructionId
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionNotFoundException
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionValidationException
import org.celllife.idart.security.defaultdosageinstruction.DefaultDosageInstructionSecurityAdapter
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

/**
 */
@Controller class DefaultDosageInstructionResourceController {

    static final Logger LOGGER = LoggerFactory.getLogger(DefaultDosageInstructionResourceController)

    @Inject DefaultDosageInstructionSecurityAdapter defaultDosageInstructionSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/defaultDosageInstructions/{defaultDosageInstructionId}", method = RequestMethod.GET, produces = "application/json")
    DefaultDosageInstructionDto findByDefaultDosageInstructionId(@PathVariable("defaultDosageInstructionId") DefaultDosageInstructionId defaultDosageInstructionId,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            return defaultDosageInstructionSecurityAdapter.findByDefaultDosageInstructionId(principal, defaultDosageInstructionId)

        } catch (DefaultDosageInstructionNotFoundException ignore) {
            LOGGER.error("Could  not find DefaultDosageInstruction with id "+defaultDosageInstructionId, ignore)
            response.setStatus(SC_NOT_FOUND)
            return null
        }
    }

    @RequestMapping(value = "/defaultDosageInstructions", method = RequestMethod.POST)
    void save(@RequestBody DefaultDosageInstructionDto defaultDosageInstructionDto, Principal principal, HttpServletResponse response) {

        try {

            DefaultDosageInstructionId defaultDosageInstructionId = defaultDosageInstructionSecurityAdapter.save(principal, defaultDosageInstructionDto)

            response.setHeader("Location", "${baseUrl}/defaultDosageInstructions/${defaultDosageInstructionId}")
            response.setStatus(SC_CREATED)

        } catch (DefaultDosageInstructionValidationException e) {
            LOGGER.error("Could not save DefaultDosageInstruction "+defaultDosageInstructionDto, e)
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
