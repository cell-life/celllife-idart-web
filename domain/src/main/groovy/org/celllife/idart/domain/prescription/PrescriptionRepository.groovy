package org.celllife.idart.domain.prescription

import org.celllife.idart.common.PrescriptionIdentifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PrescriptionRepository {

    Prescription save(Prescription prescription)

    Prescription findOne(PrescriptionIdentifier prescriptionIdentifier)

}
