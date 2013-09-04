package org.celllife.idart.application.patient

import org.celllife.idart.application.patient.dto.PatientDto
import org.celllife.idart.common.PatientId
import org.celllife.idart.domain.identifiable.Identifier
import org.celllife.idart.domain.patient.Patient

/**
 */
interface PatientApplicationService {

    Patient findByPatientId(PatientId patientId)

    Patient save(Patient patient)

    PatientId save(PatientDto patientDto)

}
