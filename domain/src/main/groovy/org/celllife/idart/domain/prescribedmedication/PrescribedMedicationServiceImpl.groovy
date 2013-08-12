package org.celllife.idart.domain.prescribedmedication

import org.celllife.idart.common.PrescribedMedicationIdentifier

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

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

        prescribedMedicationEventPublisher.prescribedMedicationSaved(prescribedMedication)

        prescribedMedicationRepository.save(prescribedMedication)
    }

    @Override
    PrescribedMedication findByPrescribedMedicationIdentifier(PrescribedMedicationIdentifier prescribedMedicationIdentifier) throws PrescribedMedicationNotFoundException {

        def prescribedMedication = prescribedMedicationRepository.findOne(prescribedMedicationIdentifier)

        if (prescribedMedication == null) {
            throw new PrescribedMedicationNotFoundException("Could not find PrescribedMedication with PrescribedMedication Identifier [${ prescribedMedicationIdentifier}]")
        }

        prescribedMedication
    }
}