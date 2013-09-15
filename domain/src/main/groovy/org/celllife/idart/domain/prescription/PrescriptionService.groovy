package org.celllife.idart.domain.prescription

import org.celllife.idart.common.PrescriptionId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PrescriptionService {

    Boolean exists(PrescriptionId prescriptionId)

    Prescription save(Prescription prescription)

    Prescription findByPrescriptionId(PrescriptionId prescriptionId)

}
