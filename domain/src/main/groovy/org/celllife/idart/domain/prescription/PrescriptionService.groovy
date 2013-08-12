package org.celllife.idart.domain.prescription

import org.celllife.idart.common.PrescriptionIdentifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PrescriptionService {

    Prescription save(Prescription prescription) throws PrescriptionValidationException

    Prescription findByPrescriptionIdentifier(PrescriptionIdentifier prescriptionIdentifier) throws PrescriptionNotFoundException

}