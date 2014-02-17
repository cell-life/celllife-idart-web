package org.celllife.idart.application.prescription

import org.celllife.idart.domain.prescription.PrescriptionEvent

/**
 * Provides the functionality to manage a prescription event (save or delete).
 * This class is triggered via a JMS topic (see spring-jms.xml - both in the source and test META-INF resources)
 */
interface PrescriptionProvider {
	
    void processEvent(PrescriptionEvent prescriptionEvent)
    void save(PrescriptionEvent prescriptionEvent)
    void delete(PrescriptionEvent prescriptionEvent)

}
