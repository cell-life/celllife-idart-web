package org.celllife.idart.domain.dispensedmedication

import org.celllife.idart.common.DispensedMedicationIdentifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface DispensedMedicationService {

    DispensedMedication save(DispensedMedication dispensedMedication) throws DispensedMedicationValidationException

    DispensedMedication findByDispensedMedicationIdentifier(DispensedMedicationIdentifier dispensedMedicationIdentifier) throws DispensedMedicationNotFoundException

}