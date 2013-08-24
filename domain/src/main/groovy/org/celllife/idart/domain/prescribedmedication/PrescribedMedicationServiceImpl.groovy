package org.celllife.idart.domain.prescribedmedication

import org.celllife.idart.common.PrescribedMedicationId

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

import static org.celllife.idart.domain.prescribedmedication.PrescribedMedicationEvent.EventType.SAVED
import static org.celllife.idart.domain.prescribedmedication.PrescribedMedicationEvent.newPrescribedMedicationEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class PrescribedMedicationServiceImpl implements PrescribedMedicationService {

    @Autowired PrescribedMedicationRepository prescribedMedicationRepository

    @Autowired PrescribedMedicationValidator prescribedMedicationValidator

    @Autowired PrescribedMedicationEventPublisher prescribedMedicationEventPublisher

    @Override
    PrescribedMedication save(PrescribedMedication prescribedMedication) throws PrescribedMedicationValidationException {

        prescribedMedicationValidator.validate(prescribedMedication)

        prescribedMedicationEventPublisher.publish(newPrescribedMedicationEvent(prescribedMedication, SAVED))

        prescribedMedicationRepository.save(prescribedMedication)
    }

    @Override
    PrescribedMedication findByPrescribedMedicationId(PrescribedMedicationId prescribedMedicationId) throws PrescribedMedicationNotFoundException {

        def prescribedMedication = prescribedMedicationRepository.findOne(prescribedMedicationId)

        if (prescribedMedication == null) {
            throw new PrescribedMedicationNotFoundException("Could not find PrescribedMedication with PrescribedMedication Id [${ prescribedMedicationId}]")
        }

        prescribedMedication
    }
}
