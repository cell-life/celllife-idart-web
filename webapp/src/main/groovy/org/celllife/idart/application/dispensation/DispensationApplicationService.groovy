package org.celllife.idart.application.dispensation

import org.celllife.idart.common.DispensationId
import org.celllife.idart.domain.dispensation.Dispensation

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface DispensationApplicationService {

    Dispensation save(Dispensation dispensation)

    Dispensation findByDispensationId(DispensationId dispensationId)

}
