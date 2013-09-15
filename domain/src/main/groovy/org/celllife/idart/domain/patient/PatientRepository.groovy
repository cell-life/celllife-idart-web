package org.celllife.idart.domain.patient

import org.celllife.idart.common.PatientId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PatientRepository {

    boolean exists(PatientId patientId)

    Patient save(Patient patient)

    Patient findOne(PatientId patientId)

}
