package org.celllife.idart.domain.defaultdosageinstruction

import org.celllife.idart.common.DefaultDosageInstructionIdentifier

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class DefaultDosageInstructionServiceImpl implements DefaultDosageInstructionService {

    @Autowired DefaultDosageInstructionRepository defaultDosageInstructionRepository

    @Autowired DefaultDosageInstructionValidator defaultDosageInstructionValidator

    @Autowired DefaultDosageInstructionEventPublisher defaultDosageInstructionEventPublisher

    @Override
    DefaultDosageInstruction save(DefaultDosageInstruction defaultDosageInstruction) throws DefaultDosageInstructionValidationException {

        defaultDosageInstructionValidator.validate(defaultDosageInstruction)

        defaultDosageInstructionEventPublisher.defaultDosageInstructionSaved(defaultDosageInstruction)

        defaultDosageInstructionRepository.save(defaultDosageInstruction)
    }

    @Override
    DefaultDosageInstruction findByDefaultDosageInstructionIdentifier(DefaultDosageInstructionIdentifier defaultDosageInstructionIdentifier) throws DefaultDosageInstructionNotFoundException {

        def defaultDosageInstruction = defaultDosageInstructionRepository.findOne(defaultDosageInstructionIdentifier)

        if (defaultDosageInstruction == null) {
            throw new DefaultDosageInstructionNotFoundException("Could not find DefaultDosageInstruction with Default Dosage Instruction Identifier [${ defaultDosageInstructionIdentifier}]")
        }

        defaultDosageInstruction
    }
}