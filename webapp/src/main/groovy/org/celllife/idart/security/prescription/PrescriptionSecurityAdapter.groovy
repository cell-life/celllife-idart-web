package org.celllife.idart.security.prescription

import org.celllife.idart.application.prescription.dto.PrescriptionDto
import org.celllife.idart.common.PrescriptionId
import org.celllife.idart.common.Identifier
import org.celllife.idart.application.prescription.PrescriptionApplicationService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class PrescriptionSecurityAdapter {

    @Inject PrescriptionApplicationService prescriptionApplicationService

    PrescriptionId save(Principal principal, PrescriptionDto prescriptionDto) {
        prescriptionApplicationService.save(prescriptionDto)
    }

    PrescriptionDto findByPrescriptionId(Principal principal, PrescriptionId prescriptionId) {
        prescriptionApplicationService.findByPrescriptionId(prescriptionId)
    }

    PrescriptionDto findByIdentifier(Principal principal, Identifier identifier) {
        prescriptionApplicationService.findByIdentifier(identifier)
    }

}
