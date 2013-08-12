package org.celllife.idart.domain.prescription

import org.celllife.idart.common.PrescriptionIdentifier

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

import static org.celllife.idart.domain.prescription.PrescriptionEvent.EventType.SAVED
import static org.celllife.idart.domain.prescription.PrescriptionEvent.newPrescriptionEvent

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

        prescriptionEventPublisher.publish(newPrescriptionEvent(prescription, SAVED))

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