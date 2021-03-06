package org.celllife.idart.security.prescribedmedication

import org.celllife.idart.application.prescribedmedication.dto.PrescribedMedicationDto
import org.celllife.idart.common.PrescribedMedicationId
import org.celllife.idart.common.Identifier
import org.celllife.idart.application.prescribedmedication.PrescribedMedicationApplicationService

import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

/**
 */
@Named class PrescribedMedicationSecurityAdapter {

    @Inject PrescribedMedicationApplicationService prescribedMedicationApplicationService

    PrescribedMedicationId save(Principal principal, PrescribedMedicationDto prescribedMedicationDto) {
        prescribedMedicationApplicationService.save(prescribedMedicationDto)
    }

    PrescribedMedicationDto findByPrescribedMedicationId(Principal principal, PrescribedMedicationId prescribedMedicationId) {
        prescribedMedicationApplicationService.findByPrescribedMedicationId(prescribedMedicationId)
    }

    PrescribedMedicationDto findByIdentifier(Principal principal, Identifier identifier) {
        prescribedMedicationApplicationService.findByIdentifier(identifier)
    }

}
