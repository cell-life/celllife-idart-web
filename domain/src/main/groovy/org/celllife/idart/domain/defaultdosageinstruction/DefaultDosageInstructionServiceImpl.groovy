package org.celllife.idart.domain.defaultdosageinstruction

import org.celllife.idart.common.DefaultDosageInstructionId

import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionEvent.EventType.SAVED
import static org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionEvent.newDefaultDosageInstructionEvent

/**
 */
@Named class DefaultDosageInstructionServiceImpl implements DefaultDosageInstructionService {

    @Inject DefaultDosageInstructionRepository defaultDosageInstructionRepository

    @Inject DefaultDosageInstructionValidator defaultDosageInstructionValidator

    @Inject DefaultDosageInstructionEventPublisher defaultDosageInstructionEventPublisher

    @Override
    Boolean exists(DefaultDosageInstructionId defaultDosageInstructionId) {
        defaultDosageInstructionRepository.exists(defaultDosageInstructionId)
    }

    @Override
    DefaultDosageInstruction save(DefaultDosageInstruction defaultDosageInstruction) {

        def existingDefaultDosageInstruction = defaultDosageInstructionRepository.findOne(defaultDosageInstruction.id)

        if (existingDefaultDosageInstruction == null) {
            existingDefaultDosageInstruction = defaultDosageInstruction
        } else {
            existingDefaultDosageInstruction.merge(defaultDosageInstruction)
        }

        defaultDosageInstructionValidator.validate(existingDefaultDosageInstruction)

        defaultDosageInstructionEventPublisher.publish(newDefaultDosageInstructionEvent(existingDefaultDosageInstruction, SAVED))

        defaultDosageInstructionRepository.save(existingDefaultDosageInstruction)
    }

    @Override
    DefaultDosageInstruction findByDefaultDosageInstructionId(DefaultDosageInstructionId defaultDosageInstructionId) {

        def defaultDosageInstruction = defaultDosageInstructionRepository.findOne(defaultDosageInstructionId)

        if (defaultDosageInstruction == null) {
            throw new DefaultDosageInstructionNotFoundException("Could not find DefaultDosageInstruction with id [${ defaultDosageInstructionId}]")
        }

        defaultDosageInstruction
    }
}
