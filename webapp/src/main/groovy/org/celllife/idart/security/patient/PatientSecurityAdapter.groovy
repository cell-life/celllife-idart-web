package org.celllife.idart.security.patient

import org.celllife.idart.common.PatientId
import org.celllife.idart.domain.patient.Patient
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

    Patient save(Principal principal, Patient patient) {
        patientApplicationService.save(patient)
    }

    Patient findByPatientId(Principal principal, PatientId patientId) {
        patientApplicationService.findByPatientId(patientId)
    }

}
