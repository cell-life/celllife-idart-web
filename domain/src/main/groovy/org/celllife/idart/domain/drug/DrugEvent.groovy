package org.celllife.idart.domain.drug

import org.celllife.idart.common.EventHeader
import org.celllife.idart.common.EventType

import static org.celllife.idart.common.EventHeader.newEventHeader

import javax.annotation.Generated

/**
 * Drug Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class DrugEvent {

    EventHeader header

    Drug drug

    static DrugEvent newDrugEvent(Drug drug, DrugEvent.EventType eventType) {
        new DrugEvent(drug: drug, header: newEventHeader(eventType))
    }

    enum EventType implements org.celllife.idart.common.EventType {
        SAVED
    }
}
