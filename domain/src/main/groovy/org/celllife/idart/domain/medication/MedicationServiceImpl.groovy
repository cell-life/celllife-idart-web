package org.celllife.idart.domain.medication

import org.celllife.idart.common.ProductId

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

import static org.celllife.idart.domain.medication.MedicationEvent.EventType.SAVED
import static org.celllife.idart.domain.medication.MedicationEvent.newMedicationEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class MedicationServiceImpl implements MedicationService {

    @Autowired MedicationRepository medicationRepository

    @Autowired MedicationValidator medicationValidator

    @Autowired MedicationEventPublisher medicationEventPublisher

    @Override
    Medication save(Medication medication) throws MedicationValidationException {

        medicationValidator.validate(medication)

        medicationEventPublisher.publish(newMedicationEvent(medication, SAVED))

        medicationRepository.save(medication)
    }

    @Override
    Medication findByProductId(ProductId productId) throws MedicationNotFoundException {

        def medication = medicationRepository.findOne(productId)

        if (medication == null) {
            throw new MedicationNotFoundException("Could not find Medication with Product Id [${ productId}]")
        }

        medication
    }
}
