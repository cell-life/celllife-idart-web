package org.celllife.idart.domain.prescribedmedication

import org.celllife.idart.common.PrescribedMedicationId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PrescribedMedicationRepository {

    boolean exists(PrescribedMedicationId prescribedMedicationId)

    PrescribedMedication save(PrescribedMedication prescribedMedication)

    PrescribedMedication findOne(PrescribedMedicationId prescribedMedicationId)

}
