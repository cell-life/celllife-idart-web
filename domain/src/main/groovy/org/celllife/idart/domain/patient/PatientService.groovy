package org.celllife.idart.domain.patient

import org.celllife.idart.common.PatientId

import javax.annotation.Generated

/**
 */
public interface PatientService {

    Patient save(Patient patient)

    Patient findByPatientId(PatientId patientId)

}
