package org.celllife.idart.interfaces.resource.patient

import org.celllife.idart.common.PatientId
import org.celllife.idart.domain.patient.Patient
import org.celllife.idart.domain.patient.PatientNotFoundException
import org.celllife.idart.domain.patient.PatientValidationException
import org.celllife.idart.security.patient.PatientSecurityAdapter
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
@Controller class PatientResourceController {

    @Inject PatientSecurityAdapter patientSecurityAdapter

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/patients/{patientId}", method = GET, produces = "application/json")
    Patient findByPatientId(@PathVariable("patientId") PatientId patientId,
                                              Principal principal,
                                              HttpServletResponse response) {

        try {

            patientSecurityAdapter.findByPatientId(principal, patientId)

        } catch (PatientNotFoundException e) {
            response.setStatus(SC_NOT_FOUND)
        }
    }

    @RequestMapping(value = "/patients", method = POST)
    void save(@RequestBody Patient patient, Principal principal, HttpServletResponse response) {

        try {

            patient = patientSecurityAdapter.save(principal, patient)

            response.setHeader("Location", "${baseUrl}/patients/${patient.id}")
            response.setStatus(SC_CREATED)

        } catch (PatientValidationException e) {
            response.setStatus(SC_BAD_REQUEST)
        }
    }
}
