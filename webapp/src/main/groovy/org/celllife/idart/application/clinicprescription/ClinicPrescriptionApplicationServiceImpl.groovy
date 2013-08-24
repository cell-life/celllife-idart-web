package org.celllife.idart.application.clinicprescription

import org.celllife.idart.application.prescription.PrescriptionProvider
import org.celllife.idart.domain.clinic.Clinic
import org.celllife.idart.domain.facility.Facility
import org.celllife.idart.domain.prescription.Prescription
import org.springframework.beans.factory.annotation.Autowired

/**
 */
class ClinicPrescriptionApplicationServiceImpl  {

    def clinicPrescriptionService

    @Autowired PrescriptionProvider prehmisClinicPrescriptionProvider

    void save(String clinicId, String prescriptionId, Prescription prescription) {

        prescription.addId(
                String.format(
                        "http://www.cell-life.org/idart/clinics/%s/prescriptions",
                        clinicId
                ),
                prescriptionId
        )

        prescription = prescriptionApplicationService.save(prescription)

        def clinic = clinicApplicationService.findById(clinicId)

        clinicPrescriptionService.save(clinic, prescription)

        postToExternalProviders(clinic, prescription)
    }

    /**
     * TODO publish event rather than execute synchronously
     *
     * @param clinic
     * @param prescription
     */
    void postToExternalProviders(Clinic clinic, Prescription prescription) {
        ((Facility) clinic).getIdSystems().each { idSystem ->

            switch (idSystem) {
                case "http://prehmis.capetown.gov.za":
                    prehmisClinicPrescriptionProvider.save(clinic, prescription)
                    break
                default:
                    break
            }
        }
    }
}
