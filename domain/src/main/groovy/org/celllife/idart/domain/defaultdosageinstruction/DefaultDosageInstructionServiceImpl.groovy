package org.celllife.idart.domain.defaultdosageinstruction

import org.celllife.idart.common.DefaultDosageInstructionId

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionEvent.EventType.SAVED
import static org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionEvent.newDefaultDosageInstructionEvent

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class DefaultDosageInstructionServiceImpl implements DefaultDosageInstructionService {

    @Inject DefaultDosageInstructionRepository defaultDosageInstructionRepository

    @Inject DefaultDosageInstructionValidator defaultDosageInstructionValidator

    @Inject DefaultDosageInstructionEventPublisher defaultDosageInstructionEventPublisher

    @Override
    DefaultDosageInstruction save(DefaultDosageInstruction defaultDosageInstruction) {

        defaultDosageInstructionValidator.validate(defaultDosageInstruction)

        defaultDosageInstructionEventPublisher.publish(newDefaultDosageInstructionEvent(defaultDosageInstruction, SAVED))

        defaultDosageInstructionRepository.save(defaultDosageInstruction)
    }

    @Override
    DefaultDosageInstruction findByDefaultDosageInstructionId(DefaultDosageInstructionId defaultDosageInstructionId) {

        def defaultDosageInstruction = defaultDosageInstructionRepository.findOne(defaultDosageInstructionId)

        if (defaultDosageInstruction == null) {
            throw new DefaultDosageInstructionNotFoundException("Could not find DefaultDosageInstruction with Default Dosage Instruction Id [${ defaultDosageInstructionId}]")
        }

        defaultDosageInstruction
    }
}
