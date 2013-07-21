package org.celllife.idart.interfaces.service.clinic

import org.celllife.idart.application.part.DrugResourceService
import org.celllife.idart.application.patient.PatientApplicationService
import org.celllife.idart.application.practitioner.PractitionerApplicationService
import org.celllife.idart.application.prescription.PrescriptionResourceService
import org.celllife.idart.domain.part.Drug
import org.celllife.idart.domain.patient.Patient
import org.celllife.idart.domain.practitioner.Practitioner
import org.celllife.idart.domain.prescription.Prescription
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

import javax.servlet.http.HttpServletResponse

import static javax.servlet.http.HttpServletResponse.SC_CREATED

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 02h36
 */
@Controller class ClinicServiceController {

    @Autowired PatientApplicationService patientApplicationService

    @Autowired PractitionerApplicationService practitionerApplicationService

    @Autowired PrescriptionResourceService prescriptionResourceService

    @Autowired DrugResourceService drugResourceService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/clinics/{clinicIdentifier}/patients/search/findByIdentifier", method = RequestMethod.GET)
    Iterable<Patient> findByPatientByIdentifier(@PathVariable("clinicIdentifier") String clinicIdentifier,
                                                @RequestParam("patientIdentifier") String patientIdentifier,
                                                @RequestHeader("X-IDART_APPLICATION_ID") String applicationId) {

        patientApplicationService.findByIdentifier(applicationId, clinicIdentifier, patientIdentifier)
    }

    @ResponseBody
    @RequestMapping(value = "/clinics/{clinicIdentifier}/practitioners", method = RequestMethod.GET)
    Iterable<Practitioner> listPractitioners(@PathVariable("clinicIdentifier") String clinicIdentifier,
                                             @RequestHeader("X-IDART_APPLICATION_ID") String applicationId) {

        practitionerApplicationService.findByClinicIdentifier(applicationId, clinicIdentifier)
    }

    @RequestMapping(value = "/clinics/{clinicIdentifier}/prescriptions", method = RequestMethod.POST)
    void savePrescription(@PathVariable("clinicIdentifier") String clinicIdentifier,
                          @RequestHeader("X-IDART_APPLICATION_ID") String applicationId,
                          @RequestBody Prescription prescription,
                          HttpServletResponse response) {

        prescription = prescriptionResourceService.save(prescription)

        response.setHeader("Location", "${baseUrl}/service/prescriptions/${prescription.pk}")
        response.setStatus(SC_CREATED)
    }

    @ResponseBody
    @RequestMapping(value = "/clinics/{clinicIdentifier}/drugs", method = RequestMethod.GET)
    Iterable<Drug> listDrugs(@PathVariable("clinicIdentifier") String clinicIdentifier,
                             @RequestHeader("X-IDART_APPLICATION_ID") String applicationId) {
        drugResourceService.findAll()
    }
}
