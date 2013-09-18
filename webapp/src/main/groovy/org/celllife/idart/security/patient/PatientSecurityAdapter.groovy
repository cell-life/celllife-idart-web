package org.celllife.idart.security.patient

import org.celllife.idart.application.patient.dto.PatientDto
import org.celllife.idart.common.PatientId
import org.celllife.idart.common.Identifier
import org.celllife.idart.application.patient.PatientApplicationService
import org.celllife.idart.framework.security.IdartSystem
import org.celllife.idart.framework.security.IdartUser

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

import static org.celllife.idart.framework.security.Principals.getUser

/**
 */
@Named class PatientSecurityAdapter {

    @Inject PatientApplicationService patientApplicationService

    PatientId save(Principal principal, PatientDto patientDto) {
        patientApplicationService.save(patientDto)
    }

    PatientDto findByPatientId(Principal principal, PatientId patientId) {
        patientApplicationService.findByPatientId(patientId)
    }

    PatientDto findByIdentifier(Principal principal, Identifier identifier) {
        patientApplicationService.findByIdentifier(identifier)
    }

    Set<PatientDto> findByIdentifier(Principal principal, String identifier) {

        def user = getUser(principal)

        if (user instanceof IdartSystem) {
            return patientApplicationService.findByIdentifierAndSystem(identifier, (user as IdartSystem).id)
        }

        if (user instanceof IdartUser) {
            return patientApplicationService.findByIdentifierAndPerson(identifier, (user as IdartUser).person)
        }

        new HashSet<PatientDto>()
    }

}
