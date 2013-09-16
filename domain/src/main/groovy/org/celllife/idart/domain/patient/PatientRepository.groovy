package org.celllife.idart.domain.patient

import org.celllife.idart.common.PatientId
import org.celllife.idart.common.PersonId

/**
 */
public interface PatientRepository {

    boolean exists(PatientId patientId)

    Patient save(Patient patient)

    Patient findOne(PatientId patientId)

    PersonId findPersonByPatientId(PatientId patientId)
}
