package org.celllife.idart.security.indication

import org.celllife.idart.application.indication.dto.IndicationDto
import org.celllife.idart.common.IndicationCode
import org.celllife.idart.domain.identifiable.Identifier
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

    IndicationCode save(Principal principal, indicationDto) {
        indicationApplicationService.save(indicationDto)
    }

    IndicationDto findByIndicationCode(Principal principal, IndicationCode indicationCode) {
        indicationApplicationService.findByIndicationCode(indicationCode)
    }

    IndicationDto findByIdentifier(Principal principal, Identifier identifier) {
        indicationApplicationService.findByIdentifier(identifier)
    }

}
