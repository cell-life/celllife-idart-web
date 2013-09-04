package org.celllife.idart.application.prescription

import org.celllife.idart.common.PrescriptionId
import org.celllife.idart.domain.prescription.Prescription

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface PrescriptionApplicationService {

    Prescription save(Prescription prescription)

    Prescription findByPrescriptionId(PrescriptionId prescriptionId)

}
