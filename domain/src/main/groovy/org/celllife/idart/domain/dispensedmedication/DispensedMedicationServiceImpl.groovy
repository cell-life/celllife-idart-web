package org.celllife.idart.domain.dispensedmedication

import org.celllife.idart.common.DispensedMedicationIdentifier

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

import static org.celllife.idart.domain.dispensedmedication.DispensedMedicationEvent.EventType.SAVED
import static org.celllife.idart.domain.dispensedmedication.DispensedMedicationEvent.newDispensedMedicationEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class DispensedMedicationServiceImpl implements DispensedMedicationService {

    @Autowired DispensedMedicationRepository dispensedMedicationRepository

    @Autowired DispensedMedicationValidator dispensedMedicationValidator

    @Autowired DispensedMedicationEventPublisher dispensedMedicationEventPublisher

    @Override
    DispensedMedication save(DispensedMedication dispensedMedication) throws DispensedMedicationValidationException {

        dispensedMedicationValidator.validate(dispensedMedication)

        dispensedMedicationEventPublisher.publish(newDispensedMedicationEvent(dispensedMedication, SAVED))

        dispensedMedicationRepository.save(dispensedMedication)
    }

    @Override
    DispensedMedication findByDispensedMedicationIdentifier(DispensedMedicationIdentifier dispensedMedicationIdentifier) throws DispensedMedicationNotFoundException {

        def dispensedMedication = dispensedMedicationRepository.findOne(dispensedMedicationIdentifier)

        if (dispensedMedication == null) {
            throw new DispensedMedicationNotFoundException("Could not find DispensedMedication with DispensedMedication Identifier [${ dispensedMedicationIdentifier}]")
        }

        dispensedMedication
    }
}