package org.celllife.idart.application.dispensation

import org.celllife.idart.common.DispensationId
import org.celllife.idart.domain.dispensation.Dispensation
import org.celllife.idart.domain.dispensation.DispensationService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class DispensationApplicationServiceImpl implements DispensationApplicationService {

    @Inject DispensationService dispensationService

    Dispensation save(Dispensation dispensation) {
        dispensationService.save(dispensation)
    }

    Dispensation findByDispensationId(DispensationId dispensationId) {
        dispensationService.findByDispensationId(dispensationId)
    }

}
