package org.celllife.idart.security.prescription

import org.celllife.idart.application.prescription.dto.PrescriptionDto
import org.celllife.idart.common.PrescriptionId
import org.celllife.idart.common.Identifier
import org.celllife.idart.application.prescription.PrescriptionApplicationService
import org.celllife.idart.framework.security.IdartSystem

import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

import static org.celllife.idart.framework.security.Principals.getUser

/**
 */
@Named class PrescriptionSecurityAdapter {

    @Inject PrescriptionApplicationService prescriptionApplicationService

    PrescriptionId save(Principal principal, PrescriptionDto prescriptionDto) {

        def user = getUser(principal)

        if (user instanceof IdartSystem) {
            return prescriptionApplicationService.save((user as IdartSystem).id, prescriptionDto)
        } else {
            return prescriptionApplicationService.save(prescriptionDto)
        }
    }

    PrescriptionDto findByPrescriptionId(Principal principal, PrescriptionId prescriptionId) {
        prescriptionApplicationService.findByPrescriptionId(prescriptionId)
    }

    PrescriptionDto findByIdentifier(Principal principal, Identifier identifier) {
        prescriptionApplicationService.findByIdentifier(identifier)
    }

}
