package org.celllife.idart.application.clinicprescription

import org.celllife.idart.application.clinic.ClinicResourceService
import org.celllife.idart.application.prescription.ClinicPrescriptionProvider
import org.celllife.idart.application.prescription.PrescriptionResourceService
import org.celllife.idart.domain.clinic.Clinic
import org.celllife.idart.domain.facility.Facility
import org.celllife.idart.domain.prescription.Prescription
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 */
@Service class ClinicPrescriptionApplicationServiceImpl  {

    @Autowired ClinicResourceService clinicResourceService

    @Autowired PrescriptionResourceService prescriptionResourceService

    def clinicPrescriptionService

    @Autowired ClinicPrescriptionProvider prehmisClinicPrescriptionProvider

    void save(String clinicIdentifier, String prescriptionIdentifier, Prescription prescription) {

        prescription.addIdentifier(
                String.format(
                        "http://www.cell-life.org/idart/clinics/%s/prescriptions",
                        clinicIdentifier
                ),
                prescriptionIdentifier
        )

        prescription = prescriptionResourceService.save(prescription)

        def clinic = clinicResourceService.findByIdentifier(clinicIdentifier)

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
        ((Facility) clinic).getIdentifierSystems().each { identifierSystem ->

            switch (identifierSystem) {
                case "http://prehmis.capetown.gov.za":
                    prehmisClinicPrescriptionProvider.save(clinic, prescription)
                    break
                default:
                    break
            }
        }
    }
}
