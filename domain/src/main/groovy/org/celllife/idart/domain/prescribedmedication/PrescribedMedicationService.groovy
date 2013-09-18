package org.celllife.idart.domain.prescribedmedication

import org.celllife.idart.common.PrescribedMedicationId


/**
 */
public interface PrescribedMedicationService {

    Boolean exists(PrescribedMedicationId prescribedMedicationId)

    PrescribedMedication save(PrescribedMedication prescribedMedication)

    PrescribedMedication findByPrescribedMedicationId(PrescribedMedicationId prescribedMedicationId)

}
