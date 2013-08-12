package org.celllife.idart.domain.medication

import org.celllife.idart.common.ProductIdentifier

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

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

        medicationEventPublisher.medicationSaved(medication)

        medicationRepository.save(medication)
    }

    @Override
    Medication findByProductIdentifier(ProductIdentifier productIdentifier) throws MedicationNotFoundException {

        def medication = medicationRepository.findOne(productIdentifier)

        if (medication == null) {
            throw new MedicationNotFoundException("Could not find Medication with Product Identifier [${ productIdentifier}]")
        }

        medication
    }
}