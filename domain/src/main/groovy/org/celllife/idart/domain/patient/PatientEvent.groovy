package org.celllife.idart.domain.patient

import org.celllife.idart.common.EventHeader

import static org.celllife.idart.common.EventHeader.newEventHeader

import javax.annotation.Generated

/**
 * Patient Domain Event
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PatientEvent implements Serializable {

    EventHeader header

    Patient patient

    static PatientEvent newPatientEvent(Patient patient, PatientEvent.EventType eventType) {
        new PatientEvent(patient: patient, header: newEventHeader(eventType))
    }

    enum EventType implements org.celllife.idart.common.EventType {
        SAVED
    }
}
