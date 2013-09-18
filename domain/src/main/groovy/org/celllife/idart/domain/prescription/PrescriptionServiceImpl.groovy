package org.celllife.idart.domain.prescription

import org.celllife.idart.common.PrescriptionId

import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.domain.prescription.PrescriptionEvent.EventType.SAVED
import static org.celllife.idart.domain.prescription.PrescriptionEvent.newPrescriptionEvent

/**
 */
@Named class PrescriptionServiceImpl implements PrescriptionService {

    @Inject PrescriptionRepository prescriptionRepository

    @Inject PrescriptionValidator prescriptionValidator

    @Inject PrescriptionEventPublisher prescriptionEventPublisher

    @Override
    Boolean exists(PrescriptionId prescriptionId) {
        prescriptionRepository.exists(prescriptionId)
    }

    @Override
    Prescription save(Prescription prescription) {

        def existingPrescription = prescriptionRepository.findOne(prescription.id)

        if (existingPrescription == null) {
            existingPrescription = prescription
        } else {
            existingPrescription.merge(prescription)
        }

        prescriptionValidator.validate(existingPrescription)

        prescriptionEventPublisher.publish(newPrescriptionEvent(existingPrescription, SAVED))

        prescriptionRepository.save(existingPrescription)
    }

    @Override
    Prescription findByPrescriptionId(PrescriptionId prescriptionId) {

        def prescription = prescriptionRepository.findOne(prescriptionId)

        if (prescription == null) {
            throw new PrescriptionNotFoundException("Could not find Prescription with id [${ prescriptionId}]")
        }

        prescription
    }
}
