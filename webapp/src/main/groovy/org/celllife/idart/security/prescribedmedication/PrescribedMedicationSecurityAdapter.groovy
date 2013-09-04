package org.celllife.idart.security.prescribedmedication

import org.celllife.idart.common.PrescribedMedicationId
import org.celllife.idart.domain.prescribedmedication.PrescribedMedication
import org.celllife.idart.application.prescribedmedication.PrescribedMedicationApplicationService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class PrescribedMedicationSecurityAdapter {

    @Inject PrescribedMedicationApplicationService prescribedMedicationApplicationService

    PrescribedMedication save(Principal principal, PrescribedMedication prescribedMedication) {
        prescribedMedicationApplicationService.save(prescribedMedication)
    }

    PrescribedMedication findByPrescribedMedicationId(Principal principal, PrescribedMedicationId prescribedMedicationId) {
        prescribedMedicationApplicationService.findByPrescribedMedicationId(prescribedMedicationId)
    }

}
