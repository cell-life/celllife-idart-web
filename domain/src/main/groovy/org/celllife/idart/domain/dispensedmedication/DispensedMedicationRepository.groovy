package org.celllife.idart.domain.dispensedmedication

import org.celllife.idart.common.DispensedMedicationId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface DispensedMedicationRepository {

    DispensedMedication save(DispensedMedication dispensedMedication)

    DispensedMedication findOne(DispensedMedicationId dispensedMedicationId)

}
