package org.celllife.idart.interfaces.service.clinic

import org.celllife.idart.application.medication.MedicationResourceService
import org.celllife.idart.application.patient.PatientApplicationService
import org.celllife.idart.application.practitioner.PractitionerApplicationService
import org.celllife.idart.application.prescription.PrescriptionResourceService
import org.celllife.idart.domain.medication.Medication
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

    @Autowired MedicationResourceService medicationResourceService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/clinics/{clinicIdentifier}/patients/search/findByIdentifier", method = RequestMethod.GET)
    Iterable<Patient> findByPatientByIdentifier(@PathVariable("clinicIdentifier") String clinicIdentifier,
                                                @RequestParam("patientIdentifier") String patientIdentifier,
                                                ) {

        patientApplicationService.findByIdentifier(applicationId, clinicIdentifier, patientIdentifier)
    }

    @ResponseBody
    @RequestMapping(value = "/clinics/{clinicIdentifier}/practitioners", method = RequestMethod.GET)
    Iterable<Practitioner> listPractitioners(@PathVariable("clinicIdentifier") String clinicIdentifier,
                                             ) {

        practitionerApplicationService.findByClinicIdentifier(applicationId, clinicIdentifier)
    }

    @RequestMapping(value = "/clinics/{clinicIdentifier}/prescriptions", method = RequestMethod.POST)
    void savePrescription(@PathVariable("clinicIdentifier") String clinicIdentifier,
                          ,
                          @RequestBody Prescription prescription,
                          HttpServletResponse response) {

        prescription = prescriptionResourceService.save(prescription)

        response.setHeader("Location", "${baseUrl}/prescriptions/${prescription.pk}")
        response.setStatus(SC_CREATED)
    }

    @RequestMapping(value = "/clinics/{clinicIdentifier}/medications", method = RequestMethod.POST)
    void saveMedication(@PathVariable("clinicIdentifier") String clinicIdentifier,
                        ,
                        @RequestBody Medication medication,
                        HttpServletResponse response) {

        medication = medicationResourceService.save(medication)

        response.setHeader("Location", "${baseUrl}/medications/${medication.pk}")
        response.setStatus(SC_CREATED)
    }
}
