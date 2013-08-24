package org.celllife.idart.application.prescription

import org.celllife.idart.domain.prescription.Prescription
import org.celllife.idart.domain.prescription.PrescriptionValidationException
import org.celllife.idart.domain.prescription.PrescriptionNotFoundException
import org.celllife.idart.common.PrescriptionId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface PrescriptionApplicationService {

    Prescription save(Prescription prescription) throws PrescriptionValidationException

    Prescription findByPrescriptionId(PrescriptionId prescriptionId) throws PrescriptionNotFoundException

}
