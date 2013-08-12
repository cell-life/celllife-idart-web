package org.celllife.idart.domain.patient

import org.celllife.idart.common.PatientIdentifier

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class PatientServiceImpl implements PatientService {

    @Autowired PatientRepository patientRepository

    @Autowired PatientValidator patientValidator

    @Autowired PatientEventPublisher patientEventPublisher

    @Override
    Patient save(Patient patient) throws PatientValidationException {

        patientValidator.validate(patient)

        patientEventPublisher.patientSaved(patient)

        patientRepository.save(patient)
    }

    @Override
    Patient findByPatientIdentifier(PatientIdentifier patientIdentifier) throws PatientNotFoundException {

        def patient = patientRepository.findOne(patientIdentifier)

        if (patient == null) {
            throw new PatientNotFoundException("Could not find Patient with Patient Identifier [${ patientIdentifier}]")
        }

        patient
    }
}