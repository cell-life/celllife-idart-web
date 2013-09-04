package org.celllife.idart.domain.prescription

import org.celllife.idart.common.PrescriptionId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PrescriptionService {

    Prescription save(Prescription prescription)

    Prescription findByPrescriptionId(PrescriptionId prescriptionId)

}
