package org.celllife.idart.security.patient

import org.celllife.idart.application.patient.dto.PatientDto
import org.celllife.idart.common.PatientId
import org.celllife.idart.domain.identifiable.Identifier
import org.celllife.idart.application.patient.PatientApplicationService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class PatientSecurityAdapter {

    @Inject PatientApplicationService patientApplicationService

    PatientId save(Principal principal, patientDto) {
        patientApplicationService.save(patientDto)
    }

    PatientDto findByPatientId(Principal principal, PatientId patientId) {
        patientApplicationService.findByPatientId(patientId)
    }

    PatientDto findByIdentifier(Principal principal, Identifier identifier) {
        patientApplicationService.findByIdentifier(identifier)
    }

}
