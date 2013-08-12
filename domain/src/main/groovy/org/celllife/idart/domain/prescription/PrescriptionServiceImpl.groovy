package org.celllife.idart.domain.prescription

import org.celllife.idart.common.PrescriptionIdentifier

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired PrescriptionRepository prescriptionRepository

    @Autowired PrescriptionValidator prescriptionValidator

    @Autowired PrescriptionEventPublisher prescriptionEventPublisher

    @Override
    Prescription save(Prescription prescription) throws PrescriptionValidationException {

        prescriptionValidator.validate(prescription)

        prescriptionEventPublisher.prescriptionSaved(prescription)

        prescriptionRepository.save(prescription)
    }

    @Override
    Prescription findByPrescriptionIdentifier(PrescriptionIdentifier prescriptionIdentifier) throws PrescriptionNotFoundException {

        def prescription = prescriptionRepository.findOne(prescriptionIdentifier)

        if (prescription == null) {
            throw new PrescriptionNotFoundException("Could not find Prescription with Prescription Identifier [${ prescriptionIdentifier}]")
        }

        prescription
    }
}