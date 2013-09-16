package org.celllife.idart.domain.patient

import org.celllife.idart.common.PatientId
import org.celllife.idart.common.PersonId

/**
 */
public interface PatientService {

    Patient save(Patient patient)

    Patient findByPatientId(PatientId patientId)

    PersonId findPersonByPatientId(PatientId patientId)
}
