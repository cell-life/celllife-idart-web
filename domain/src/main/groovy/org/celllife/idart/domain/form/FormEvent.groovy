package org.celllife.idart.domain.form

import javax.annotation.Generated

/**
 * Form Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class FormEvent implements Serializable {

    Date timestamp

    UUID uuid

    EventType type

    String username

    Form form

    static FormEvent newFormEvent(Form form, FormEvent.EventType eventType) {

        new FormEvent(
            form: form,
            type: eventType,
            timestamp: new Date(),
            uuid: UUID.randomUUID()
        )
    }

    enum EventType {
        SAVED
    }
}
