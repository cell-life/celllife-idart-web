package org.celllife.idart.domain.patient


/**
 */
interface PatientEventPublisher {

    void publish(PatientEvent patientEvent)

}
