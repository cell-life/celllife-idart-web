package org.celllife.idart.domain.dispensation

import org.celllife.idart.common.DispensationId


/**
 */
public interface DispensationRepository {

    boolean exists(DispensationId dispensationId)

    Dispensation save(Dispensation dispensation)

    Dispensation findOne(DispensationId dispensationId)

}
