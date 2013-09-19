package org.celllife.idart.security.dispensation

import org.celllife.idart.application.dispensation.dto.DispensationDto
import org.celllife.idart.application.prescription.PrescriptionApplicationService
import org.celllife.idart.application.prescription.dto.PrescriptionDto
import org.celllife.idart.common.DispensationId
import org.celllife.idart.common.Identifier
import org.celllife.idart.application.dispensation.DispensationApplicationService
import org.celllife.idart.common.PrescriptionId
import org.celllife.idart.framework.security.IdartSystem

import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

import static org.celllife.idart.framework.security.Principals.getUser

/**
 */
@Named class DispensationSecurityAdapter {

    @Inject DispensationApplicationService dispensationApplicationService

    DispensationId save(Principal principal, DispensationDto dispensationDto) {

        def user = getUser(principal)

        if (user instanceof IdartSystem) {
            return dispensationApplicationService.save((user as IdartSystem).id, dispensationDto)
        } else {
            return dispensationApplicationService.save(dispensationDto)
        }
    }

    DispensationDto findByDispensationId(Principal principal, DispensationId dispensationId) {
        dispensationApplicationService.findByDispensationId(dispensationId)
    }

    DispensationDto findByIdentifier(Principal principal, Identifier identifier) {
        dispensationApplicationService.findByIdentifier(identifier)
    }

}
