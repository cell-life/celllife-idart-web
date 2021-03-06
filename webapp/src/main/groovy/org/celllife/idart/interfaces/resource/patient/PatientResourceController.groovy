package org.celllife.idart.interfaces.resource.patient

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST
import static javax.servlet.http.HttpServletResponse.SC_CREATED
import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND

import java.security.Principal

import javax.inject.Inject
import javax.servlet.http.HttpServletResponse

import org.celllife.idart.application.patient.dto.PatientDto
import org.celllife.idart.common.PatientId
import org.celllife.idart.domain.patient.PatientNotFoundException
import org.celllife.idart.domain.patient.PatientValidationException
import org.celllife.idart.security.patient.PatientSecurityAdapter
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

/**
 */
@Controller class PatientResourceController {

    static final Logger LOGGER = LoggerFactory.getLogger(PatientResourceController)

    @Inject PatientSecurityAdapter patientSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/patients/search/findByIdentifier", method = RequestMethod.GET, produces = "application/json")
    Set<PatientDto> findByIdentifier(@RequestParam("identifier") String identifier, Principal principal) {

        patientSecurityAdapter.findByIdentifier(principal, identifier)
    }

    @ResponseBody
    @RequestMapping(value = "/patients/{patientId}", method = RequestMethod.GET, produces = "application/json")
    PatientDto findByPatientId(@PathVariable("patientId") PatientId patientId,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            return patientSecurityAdapter.findByPatientId(principal, patientId)

        } catch (PatientNotFoundException ignore) {
            LOGGER.error("Could not find patient with id "+patientId, ignore)
            response.setStatus(SC_NOT_FOUND)
            return null
        }
    }

    @RequestMapping(value = "/patients", method = RequestMethod.POST)
    void save(@RequestBody PatientDto patientDto, Principal principal, HttpServletResponse response) {

        try {

            PatientId patientId = patientSecurityAdapter.save(principal, patientDto)

            response.setHeader("Location", "${baseUrl}/patients/${patientId}")
            response.setStatus(SC_CREATED)

        } catch (PatientValidationException e) {
            LOGGER.error("Could not save patient "+patientDto, e)
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
