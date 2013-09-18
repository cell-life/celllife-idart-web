package org.celllife.idart.domain.prescribedmedication

import org.celllife.idart.common.PrescribedMedicationId


/**
 */
public interface PrescribedMedicationRepository {

    boolean exists(PrescribedMedicationId prescribedMedicationId)

    PrescribedMedication save(PrescribedMedication prescribedMedication)

    PrescribedMedication findOne(PrescribedMedicationId prescribedMedicationId)

}
