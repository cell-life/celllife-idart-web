package org.celllife.idart.application.prescribedmedication

import org.celllife.idart.common.PrescribedMedicationId
import org.celllife.idart.domain.prescribedmedication.PrescribedMedication

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface PrescribedMedicationApplicationService {

    PrescribedMedication save(PrescribedMedication prescribedMedication)

    PrescribedMedication findByPrescribedMedicationId(PrescribedMedicationId prescribedMedicationId)

}
