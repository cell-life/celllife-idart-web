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

    @Override
    PrescribedMedication save(PrescribedMedication prescribedMedication) {

        prescribedMedicationValidator.validate(prescribedMedication)

        prescribedMedicationEventPublisher.publish(newPrescribedMedicationEvent(prescribedMedication, SAVED))

        prescribedMedicationRepository.save(prescribedMedication)
    }

    @Override
    PrescribedMedication findByPrescribedMedicationId(PrescribedMedicationId prescribedMedicationId) {

        def prescribedMedication = prescribedMedicationRepository.findOne(prescribedMedicationId)

        if (prescribedMedication == null) {
            throw new PrescribedMedicationNotFoundException("Could not find PrescribedMedication with PrescribedMedication Id [${ prescribedMedicationId}]")
        }

        prescribedMedication
    }
}
