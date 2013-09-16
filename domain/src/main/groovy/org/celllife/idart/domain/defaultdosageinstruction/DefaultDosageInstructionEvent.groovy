package org.celllife.idart.domain.defaultdosageinstruction

import org.celllife.idart.common.EventHeader

import static org.celllife.idart.common.EventHeader.newEventHeader

import javax.annotation.Generated

/**
 * Default Dosage Instruction Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class DefaultDosageInstructionEvent implements Serializable {

    EventHeader header

    DefaultDosageInstruction defaultDosageInstruction

    static DefaultDosageInstructionEvent newDefaultDosageInstructionEvent(DefaultDosageInstruction defaultDosageInstruction, DefaultDosageInstructionEvent.EventType eventType) {
        new DefaultDosageInstructionEvent(defaultDosageInstruction: defaultDosageInstruction, header: newEventHeader(eventType))
    }

    enum EventType implements org.celllife.idart.common.EventType {
        SAVED
    }
}
