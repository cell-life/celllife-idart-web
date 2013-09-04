package org.celllife.idart.application.patient.dto

import org.celllife.idart.domain.patient.Patient

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-25
 * Time: 09h10
 */
class PatientDtoAssembler {

    static Patient toPatient(PatientDto patientDto) {
        copyToPatient(patientDto, new Patient())
    }

    static copyToPatient(PatientDto patientDto, Patient patient) {

        patient.with {
            valid = patientDto.valid
        }

        patient
    }
}
