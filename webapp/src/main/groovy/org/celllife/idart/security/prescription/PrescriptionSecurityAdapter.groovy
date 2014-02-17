package org.celllife.idart.security.prescription

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.celllife.idart.application.prescription.dto.PrescriptionDto
import org.celllife.idart.common.PrescriptionId
import org.celllife.idart.common.Identifier
import org.celllife.idart.application.prescription.PrescriptionApplicationService
import org.celllife.idart.framework.security.IdartSystem
import org.celllife.idart.framework.security.IdartUser
import org.slf4j.Logger;

import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

import static org.celllife.idart.framework.security.Principals.getUser

/**
 */
@Named class PrescriptionSecurityAdapter {
    
    static final Logger LOGGER = LoggerFactory.getLogger(PrescriptionSecurityAdapter)

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

    PrescriptionDto deleteByIdentifier(Principal principal, String identifier) {
        def user = getUser(principal)
        LOGGER.info("user '"+user.username+"' is deleting prescription "+identifier);
        if (user instanceof IdartSystem) {
            return prescriptionApplicationService.deleteByIdentifierAndSystem(identifier, (user as IdartSystem).id)
        }
    
        if (user instanceof IdartUser) {
            return prescriptionApplicationService.deleteByIdentifierAndPerson(identifier, (user as IdartUser).person)
        }        
    }

	PrescriptionDto deleteByPrescriptionId(Principal principal, PrescriptionId prescriptionId) {
		prescriptionApplicationService.deleteByPrescriptionId(prescriptionId)
	}

    PrescriptionDto findByIdentifier(Principal principal, Identifier identifier) {
        prescriptionApplicationService.findByIdentifier(identifier)
    }

}
