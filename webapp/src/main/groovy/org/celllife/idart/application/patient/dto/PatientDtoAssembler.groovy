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
            if (patientDto.valid != null) {
                valid = patientDto.valid
            }
        }

        patient
    }

    static PatientDto toPatientDto(Patient patient) {
        copyToPatientDto(patient, new PatientDto())
    }

    static copyToPatientDto(Patient patient, PatientDto patientDto) {

        patientDto.with {
            if (patient.valid != null) {
                valid = patient.valid
            }
        }

        patientDto
    }
}
