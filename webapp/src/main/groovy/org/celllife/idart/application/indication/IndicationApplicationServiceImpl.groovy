package org.celllife.idart.application.indication

import org.celllife.idart.common.IndicationCode
import org.celllife.idart.domain.indication.Indication
import org.celllife.idart.domain.indication.IndicationService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class IndicationApplicationServiceImpl implements IndicationApplicationService {

    @Inject IndicationService indicationService

    Indication save(Indication indication) {
        indicationService.save(indication)
    }

    Indication findByIndicationCode(IndicationCode indicationCode) {
        indicationService.findByIndicationCode(indicationCode)
    }

}
