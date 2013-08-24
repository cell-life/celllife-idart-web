package org.celllife.idart.application.prescribedmedication

import org.celllife.idart.domain.prescribedmedication.PrescribedMedication
import org.celllife.idart.domain.prescribedmedication.PrescribedMedicationValidationException
import org.celllife.idart.domain.prescribedmedication.PrescribedMedicationNotFoundException
import org.celllife.idart.common.PrescribedMedicationId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface PrescribedMedicationApplicationService {

    PrescribedMedication save(PrescribedMedication prescribedMedication) throws PrescribedMedicationValidationException

    PrescribedMedication findByPrescribedMedicationId(PrescribedMedicationId prescribedMedicationId) throws PrescribedMedicationNotFoundException

}
