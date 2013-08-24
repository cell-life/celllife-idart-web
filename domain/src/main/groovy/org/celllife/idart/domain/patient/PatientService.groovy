package org.celllife.idart.domain.patient

import org.celllife.idart.common.PatientId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PatientService {

    Patient save(Patient patient) throws PatientValidationException

    Patient findByPatientId(PatientId patientId) throws PatientNotFoundException

}
