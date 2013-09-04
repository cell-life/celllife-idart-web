package org.celllife.idart.security.prescription

import org.celllife.idart.common.PrescriptionId
import org.celllife.idart.domain.prescription.Prescription
import org.celllife.idart.application.prescription.PrescriptionApplicationService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class PrescriptionSecurityAdapter {

    @Inject PrescriptionApplicationService prescriptionApplicationService

    Prescription save(Principal principal, Prescription prescription) {
        prescriptionApplicationService.save(prescription)
    }

    Prescription findByPrescriptionId(Principal principal, PrescriptionId prescriptionId) {
        prescriptionApplicationService.findByPrescriptionId(prescriptionId)
    }

}
