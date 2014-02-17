package org.celllife.idart.domain.dispensation

import org.celllife.idart.common.DispensationId
import org.celllife.idart.common.PrescriptionId;


/**
 */
public interface DispensationService {

    Boolean exists(DispensationId dispensationId)

    Dispensation save(Dispensation dispensation)

    Dispensation findByDispensationId(DispensationId dispensationId)

    Dispensation deleteByDispensationId(DispensationId dispensationId)
    
    Dispensation finaliseDelete(DispensationId dispensationId)
}
