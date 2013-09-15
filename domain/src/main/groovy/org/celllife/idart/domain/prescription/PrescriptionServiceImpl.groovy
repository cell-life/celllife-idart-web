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
    
    @Inject PrescriptionSequence prescriptionSequence
    
    @Override
    Boolean exists(PrescriptionId prescriptionId) {
        prescriptionRepository.exists(prescriptionId)
    }
    
    @Override
    Prescription save(Prescription prescription) {

        def existingPrescription = null

        if (prescription.id != null) {
            existingPrescription = prescriptionRepository.findOne(prescription.id)
        } else {
            prescription.id = prescriptionSequence.nextValue()
        }

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
