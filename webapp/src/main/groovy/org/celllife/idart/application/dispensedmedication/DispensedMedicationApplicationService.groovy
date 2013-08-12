package org.celllife.idart.application.dispensedmedication

import org.celllife.idart.domain.dispensedmedication.DispensedMedication
import org.celllife.idart.domain.dispensedmedication.DispensedMedicationValidationException
import org.celllife.idart.domain.dispensedmedication.DispensedMedicationNotFoundException
import org.celllife.idart.common.DispensedMedicationIdentifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface DispensedMedicationApplicationService {

    DispensedMedication save(DispensedMedication dispensedMedication) throws DispensedMedicationValidationException

    DispensedMedication findByDispensedMedicationIdentifier(DispensedMedicationIdentifier dispensedMedicationIdentifier) throws DispensedMedicationNotFoundException

}