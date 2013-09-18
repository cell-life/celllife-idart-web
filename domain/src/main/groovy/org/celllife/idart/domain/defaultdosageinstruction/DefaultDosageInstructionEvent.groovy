package org.celllife.idart.domain.defaultdosageinstruction

import javax.annotation.Generated

/**
 * Default Dosage Instruction Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class DefaultDosageInstructionEvent implements Serializable {

    Date timestamp

    UUID uuid

    EventType type

    String username

    DefaultDosageInstruction defaultDosageInstruction

    static DefaultDosageInstructionEvent newDefaultDosageInstructionEvent(DefaultDosageInstruction defaultDosageInstruction, DefaultDosageInstructionEvent.EventType eventType) {

        new DefaultDosageInstructionEvent(
            defaultDosageInstruction: defaultDosageInstruction,
            type: eventType,
            timestamp: new Date(),
            uuid: UUID.randomUUID()
        )
    }

    enum EventType {
        SAVED
    }
}
