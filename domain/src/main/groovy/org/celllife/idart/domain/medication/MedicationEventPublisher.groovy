package org.celllife.idart.domain.medication

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface MedicationEventPublisher {

    void medicationSaved(Medication medication)

}