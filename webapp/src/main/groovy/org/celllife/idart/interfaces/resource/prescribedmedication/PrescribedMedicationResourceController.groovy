package org.celllife.idart.interfaces.resource.prescribedmedication

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST
import static javax.servlet.http.HttpServletResponse.SC_CREATED
import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND

import java.security.Principal

import javax.inject.Inject
import javax.servlet.http.HttpServletResponse

import org.celllife.idart.application.prescribedmedication.dto.PrescribedMedicationDto
import org.celllife.idart.common.PrescribedMedicationId
import org.celllife.idart.domain.prescribedmedication.PrescribedMedicationNotFoundException
import org.celllife.idart.domain.prescribedmedication.PrescribedMedicationValidationException
import org.celllife.idart.security.prescribedmedication.PrescribedMedicationSecurityAdapter
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
@Controller class PrescribedMedicationResourceController {

    static final Logger LOGGER = LoggerFactory.getLogger(PrescribedMedicationResourceController)

    @Inject PrescribedMedicationSecurityAdapter prescribedMedicationSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/prescribedMedications/{prescribedMedicationId}", method = RequestMethod.GET, produces = "application/json")
    PrescribedMedicationDto findByPrescribedMedicationId(@PathVariable("prescribedMedicationId") PrescribedMedicationId prescribedMedicationId,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            return prescribedMedicationSecurityAdapter.findByPrescribedMedicationId(principal, prescribedMedicationId)

        } catch (PrescribedMedicationNotFoundException ignore) {
            LOGGER.error("Could not find PrescribedMedications with id "+prescribedMedicationId, ignore)
            response.setStatus(SC_NOT_FOUND)
            return null
        }
    }

    @RequestMapping(value = "/prescribedMedications", method = RequestMethod.POST)
    void save(@RequestBody PrescribedMedicationDto prescribedMedicationDto, Principal principal, HttpServletResponse response) {

        try {

            PrescribedMedicationId prescribedMedicationId = prescribedMedicationSecurityAdapter.save(principal, prescribedMedicationDto)

            response.setHeader("Location", "${baseUrl}/prescribedMedications/${prescribedMedicationId}")
            response.setStatus(SC_CREATED)

        } catch (PrescribedMedicationValidationException e) {
            LOGGER.error("Could not save PrescribedMedication  "+prescribedMedicationDto, e)
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
