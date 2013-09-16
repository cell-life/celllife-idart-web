package org.celllife.idart.application.patient.dto

import org.celllife.idart.domain.patient.Patient

import javax.inject.Named

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-25
 * Time: 09h10
 */
@Named class PatientDtoAssembler {

    Patient toPatient(PatientDto patientDto) {

        def patient = new Patient()
        patient.with {
            if (patientDto.valid != null) {
                valid = patientDto.valid
            }
        }

        patient
    }

    PatientDto toPatientDto(Patient patient) {

        def patientDto = new PatientDto()
        patientDto.with {

            if (patient.valid != null) {
                valid = patient.valid
            }
        }

        patientDto
    }
}
