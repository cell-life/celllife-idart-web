package org.celllife.idart.interfaces.service.clinic

import org.celllife.idart.application.clinicmedication.ClinicMedicationResourceService
import org.celllife.idart.application.clinicpatient.ClinicPatientResourceService
import org.celllife.idart.application.clinicpractitioner.ClinicPractitionerResourceService
import org.celllife.idart.application.clinicprescription.ClinicPrescriptionResourceService
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

    @Autowired ClinicMedicationResourceService clinicMedicationResourceService

    @Autowired ClinicPrescriptionResourceService clinicPrescriptionResourceService

    @Autowired ClinicPractitionerResourceService clinicPractitionerResourceService

    @Autowired ClinicPatientResourceService clinicPatientResourceService

    @Value('${external.base.url}') String baseUrl

    @ResponseBody
    @RequestMapping(value = "/clinics/{clinicIdentifier}/patients/search/findByIdentifier", method = RequestMethod.GET)
    Iterable<Patient> findByPatientByIdentifier(@PathVariable("clinicIdentifier") String clinicIdentifier,
                                                @RequestParam("patientIdentifier") String patientIdentifier) {

        clinicPatientResourceService
                .findPatientsByClinicIdentifierAndPatientIdentifier(clinicIdentifier, patientIdentifier)
    }

    @ResponseBody
    @RequestMapping(value = "/clinics/{clinicIdentifier}/practitioners", method = RequestMethod.GET)
    Iterable<Practitioner> listPractitioners(@PathVariable("clinicIdentifier") String clinicIdentifier) {

        clinicPractitionerResourceService.findPractitionersByClinicIdentifier(clinicIdentifier)
    }

    @RequestMapping(value = "/clinics/{clinicIdentifier}/prescriptions/{prescriptionIdentifier}", method = RequestMethod.PUT)
    void savePrescription(@PathVariable("clinicIdentifier") String clinicIdentifier,
                          @PathVariable("prescriptionIdentifier") String prescriptionIdentifier,
                          @RequestBody Prescription prescription,
                          HttpServletResponse response) {

        clinicPrescriptionResourceService.save(clinicIdentifier, prescriptionIdentifier, prescription)

        response.setStatus(SC_CREATED)
    }

    @RequestMapping(value = "/clinics/{clinicIdentifier}/medications/{medicationIdentifier}", method = RequestMethod.PUT)
    void saveMedication(@PathVariable("clinicIdentifier") String clinicIdentifier,
                        @PathVariable("medicationIdentifier") String medicationIdentifier,
                        @RequestBody Medication medication,
                        HttpServletResponse response) {

        clinicMedicationResourceService.save(clinicIdentifier, medicationIdentifier, medication)

        response.setStatus(SC_CREATED)
    }
}
