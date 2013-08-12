package org.celllife.idart.domain.form

import org.celllife.idart.common.EventHeader
import org.celllife.idart.common.EventType

import static org.celllife.idart.common.EventHeader.newEventHeader

import javax.annotation.Generated

/**
 * Form Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class FormEvent {

    EventHeader header

    Form form

    static FormEvent newFormEvent(Form form, FormEvent.EventType eventType) {
        new FormEvent(form: form, header: newEventHeader(eventType))
    }

    enum EventType implements org.celllife.idart.common.EventType {
        SAVED
    }
}
