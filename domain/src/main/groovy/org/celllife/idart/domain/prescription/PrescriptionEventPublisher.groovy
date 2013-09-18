package org.celllife.idart.domain.prescription


/**
 */
interface PrescriptionEventPublisher {

    void publish(PrescriptionEvent prescriptionEvent)

}
