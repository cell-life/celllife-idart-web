package org.celllife.idart.domain.prescribedmedication

import org.celllife.idart.common.PrescribedMedicationIdentifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PrescribedMedicationService {

    PrescribedMedication save(PrescribedMedication prescribedMedication) throws PrescribedMedicationValidationException

    PrescribedMedication findByPrescribedMedicationIdentifier(PrescribedMedicationIdentifier prescribedMedicationIdentifier) throws PrescribedMedicationNotFoundException

}