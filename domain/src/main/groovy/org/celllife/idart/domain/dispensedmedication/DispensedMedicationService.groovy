package org.celllife.idart.domain.dispensedmedication

import org.celllife.idart.common.DispensedMedicationId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface DispensedMedicationService {

    DispensedMedication save(DispensedMedication dispensedMedication) throws DispensedMedicationValidationException

    DispensedMedication findByDispensedMedicationId(DispensedMedicationId dispensedMedicationId) throws DispensedMedicationNotFoundException

}
