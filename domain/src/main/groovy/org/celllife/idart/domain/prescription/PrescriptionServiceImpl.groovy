package org.celllife.idart.domain.prescription

import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.domain.prescription.PrescriptionEvent.EventType.SAVED
import static org.celllife.idart.domain.prescription.PrescriptionEvent.EventType.DELETED
import static org.celllife.idart.domain.prescription.PrescriptionEvent.newPrescriptionEvent
import org.celllife.idart.common.PrescribedMedicationId
import org.celllife.idart.common.PrescriptionId

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

    @Override
    PrescriptionId findByPrescribedMedication(PrescribedMedicationId prescribedMedication) {

        prescriptionRepository.findByPrescribedMedication(prescribedMedication)

    }
	
	@Override
	Prescription deleteByPrescriptionId(PrescriptionId prescriptionId) {
		Prescription p = findByPrescriptionId(prescriptionId)
		prescriptionEventPublisher.publish(newPrescriptionEvent(p, DELETED))
		p
	}
	
	@Override
	Prescription finaliseDelete(PrescriptionId prescriptionId) {
		return prescriptionRepository.delete(prescriptionId)
	}
}
