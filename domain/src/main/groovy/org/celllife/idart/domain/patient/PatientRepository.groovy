package org.celllife.idart.domain.patient

import org.celllife.idart.common.PatientIdentifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PatientRepository {

    Patient save(Patient patient)

    Patient findOne(PatientIdentifier patientIdentifier)

}
