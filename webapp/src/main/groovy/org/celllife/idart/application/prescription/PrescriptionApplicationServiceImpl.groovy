package org.celllife.idart.application.prescription

import org.celllife.idart.common.PrescriptionId
import org.celllife.idart.domain.prescription.Prescription
import org.celllife.idart.domain.prescription.PrescriptionService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class PrescriptionApplicationServiceImpl implements PrescriptionApplicationService {

    @Inject PrescriptionService prescriptionService

    Prescription save(Prescription prescription) {
        prescriptionService.save(prescription)
    }

    Prescription findByPrescriptionId(PrescriptionId prescriptionId) {
        prescriptionService.findByPrescriptionId(prescriptionId)
    }

}
