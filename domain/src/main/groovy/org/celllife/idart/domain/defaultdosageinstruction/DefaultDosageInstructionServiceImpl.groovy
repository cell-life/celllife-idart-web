package org.celllife.idart.domain.defaultdosageinstruction

import org.celllife.idart.common.DefaultDosageInstructionId

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

import static org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionEvent.EventType.SAVED
import static org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionEvent.newDefaultDosageInstructionEvent

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

        defaultDosageInstructionEventPublisher.publish(newDefaultDosageInstructionEvent(defaultDosageInstruction, SAVED))

        defaultDosageInstructionRepository.save(defaultDosageInstruction)
    }

    @Override
    DefaultDosageInstruction findByDefaultDosageInstructionId(DefaultDosageInstructionId defaultDosageInstructionId) throws DefaultDosageInstructionNotFoundException {

        def defaultDosageInstruction = defaultDosageInstructionRepository.findOne(defaultDosageInstructionId)

        if (defaultDosageInstruction == null) {
            throw new DefaultDosageInstructionNotFoundException("Could not find DefaultDosageInstruction with Default Dosage Instruction Id [${ defaultDosageInstructionId}]")
        }

        defaultDosageInstruction
    }
}
