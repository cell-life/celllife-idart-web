package org.celllife.idart.domain.patient

import org.celllife.idart.common.PatientIdentifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PatientService {

    Patient save(Patient patient) throws PatientValidationException

    Patient findByPatientIdentifier(PatientIdentifier patientIdentifier) throws PatientNotFoundException

}