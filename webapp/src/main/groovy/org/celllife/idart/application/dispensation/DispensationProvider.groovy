package org.celllife.idart.application.dispensation

import org.celllife.idart.domain.dispensation.DispensationEvent

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-19
 * Time: 17h42
 */
public interface DispensationProvider {

    void save(DispensationEvent dispensationEvent)

}