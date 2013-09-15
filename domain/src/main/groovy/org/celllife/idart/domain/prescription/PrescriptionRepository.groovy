package org.celllife.idart.domain.prescription

import org.celllife.idart.common.PrescriptionId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PrescriptionRepository {

    boolean exists(PrescriptionId prescriptionId)

    Prescription save(Prescription prescription)

    Prescription findOne(PrescriptionId prescriptionId)

}
