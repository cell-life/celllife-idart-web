package org.celllife.idart.domain.dispensation

import org.celllife.idart.common.DispensationId


/**
 */
public interface DispensationService {

    Boolean exists(DispensationId dispensationId)

    Dispensation save(Dispensation dispensation)

    Dispensation findByDispensationId(DispensationId dispensationId)

}
