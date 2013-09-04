package org.celllife.idart.security.indication

import org.celllife.idart.common.IndicationCode
import org.celllife.idart.domain.indication.Indication
import org.celllife.idart.application.indication.IndicationApplicationService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class IndicationSecurityAdapter {

    @Inject IndicationApplicationService indicationApplicationService

    Indication save(Principal principal, Indication indication) {
        indicationApplicationService.save(indication)
    }

    Indication findByIndicationCode(Principal principal, IndicationCode indicationCode) {
        indicationApplicationService.findByIndicationCode(indicationCode)
    }

}
