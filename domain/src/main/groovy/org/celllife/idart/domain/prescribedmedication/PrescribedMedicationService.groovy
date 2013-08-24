package org.celllife.idart.domain.prescribedmedication

import org.celllife.idart.common.PrescribedMedicationId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PrescribedMedicationService {

    PrescribedMedication save(PrescribedMedication prescribedMedication) throws PrescribedMedicationValidationException

    PrescribedMedication findByPrescribedMedicationId(PrescribedMedicationId prescribedMedicationId) throws PrescribedMedicationNotFoundException

}
