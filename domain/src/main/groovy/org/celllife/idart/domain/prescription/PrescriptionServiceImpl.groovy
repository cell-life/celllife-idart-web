package org.celllife.idart.domain.prescription

import org.celllife.idart.common.PrescriptionId

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.domain.prescription.PrescriptionEvent.EventType.SAVED
import static org.celllife.idart.domain.prescription.PrescriptionEvent.newPrescriptionEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class PrescriptionServiceImpl implements PrescriptionService {

    @Inject PrescriptionRepository prescriptionRepository

    @Inject PrescriptionValidator prescriptionValidator

    @Inject PrescriptionEventPublisher prescriptionEventPublisher

    @Override
    Prescription save(Prescription prescription) {

        prescriptionValidator.validate(prescription)

        prescriptionEventPublisher.publish(newPrescriptionEvent(prescription, SAVED))

        prescriptionRepository.save(prescription)
    }

    @Override
    Prescription findByPrescriptionId(PrescriptionId prescriptionId) {

        def prescription = prescriptionRepository.findOne(prescriptionId)

        if (prescription == null) {
            throw new PrescriptionNotFoundException("Could not find Prescription with Prescription Id [${ prescriptionId}]")
        }

        prescription
    }
}
