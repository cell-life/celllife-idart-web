package org.celllife.idart.domain.prescribedmedication

import org.celllife.idart.common.PrescribedMedicationIdentifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PrescribedMedicationRepository {

    PrescribedMedication save(PrescribedMedication prescribedMedication)

    PrescribedMedication findOne(PrescribedMedicationIdentifier prescribedMedicationIdentifier)

}
