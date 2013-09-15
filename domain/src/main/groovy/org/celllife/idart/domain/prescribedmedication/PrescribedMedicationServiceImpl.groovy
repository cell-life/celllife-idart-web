package org.celllife.idart.domain.prescribedmedication

import org.celllife.idart.common.PrescribedMedicationId

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.domain.prescribedmedication.PrescribedMedicationEvent.EventType.SAVED
import static org.celllife.idart.domain.prescribedmedication.PrescribedMedicationEvent.newPrescribedMedicationEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class PrescribedMedicationServiceImpl implements PrescribedMedicationService {

    @Inject PrescribedMedicationRepository prescribedMedicationRepository

    @Inject PrescribedMedicationValidator prescribedMedicationValidator

    @Inject PrescribedMedicationEventPublisher prescribedMedicationEventPublisher
    
    @Inject PrescribedMedicationSequence prescribedMedicationSequence
    
    @Override
    Boolean exists(PrescribedMedicationId prescribedMedicationId) {
        prescribedMedicationRepository.exists(prescribedMedicationId)
    }
    
    @Override
    PrescribedMedication save(PrescribedMedication prescribedMedication) {

        def existingPrescribedMedication = null

        if (prescribedMedication.id != null) {
            existingPrescribedMedication = prescribedMedicationRepository.findOne(prescribedMedication.id)
        } else {
            prescribedMedication.id = prescribedMedicationSequence.nextValue()
        }

        if (existingPrescribedMedication == null) {
            existingPrescribedMedication = prescribedMedication
        } else {
            existingPrescribedMedication.merge(prescribedMedication)
        }

        prescribedMedicationValidator.validate(existingPrescribedMedication)

        prescribedMedicationEventPublisher.publish(newPrescribedMedicationEvent(existingPrescribedMedication, SAVED))

        prescribedMedicationRepository.save(existingPrescribedMedication)
    }
    
    @Override
    PrescribedMedication findByPrescribedMedicationId(PrescribedMedicationId prescribedMedicationId) {

        def prescribedMedication = prescribedMedicationRepository.findOne(prescribedMedicationId)

        if (prescribedMedication == null) {
            throw new PrescribedMedicationNotFoundException("Could not find PrescribedMedication with id [${ prescribedMedicationId}]")
        }

        prescribedMedication
    }
}
