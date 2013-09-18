package org.celllife.idart.domain.defaultdosageinstruction


/**
 * Default Dosage Instruction Domain Event
 */
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
