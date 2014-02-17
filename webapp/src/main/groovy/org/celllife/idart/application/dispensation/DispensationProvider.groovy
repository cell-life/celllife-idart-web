package org.celllife.idart.application.dispensation

import org.celllife.idart.domain.dispensation.DispensationEvent

/**
 * Provides the functionality to manage a dispensation event (save or delete).
 * This class is triggered via a JMS topic (see spring-jms.xml - both in the source and test META-INF resources)
 */
public interface DispensationProvider {

    void processEvent(DispensationEvent dispensationEvent)
    void save(DispensationEvent dispensationEvent)
    void delete(DispensationEvent dispensationEvent)

}