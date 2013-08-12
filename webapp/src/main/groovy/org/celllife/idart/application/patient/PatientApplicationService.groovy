package org.celllife.idart.application.patient

import org.celllife.idart.domain.patient.Patient
import org.celllife.idart.domain.patient.PatientValidationException
import org.celllife.idart.domain.patient.PatientNotFoundException
import org.celllife.idart.common.PatientIdentifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface PatientApplicationService {

    Patient save(Patient patient) throws PatientValidationException

    Patient findByPatientIdentifier(PatientIdentifier patientIdentifier) throws PatientNotFoundException

}