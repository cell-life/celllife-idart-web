package org.celllife.idart.security.substitutionreason

import org.celllife.idart.application.substitutionreason.dto.SubstitutionReasonDto
import org.celllife.idart.common.SubstitutionReasonCode
import org.celllife.idart.domain.identifiable.Identifier
import org.celllife.idart.application.substitutionreason.SubstitutionReasonApplicationService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class SubstitutionReasonSecurityAdapter {

    @Inject SubstitutionReasonApplicationService substitutionReasonApplicationService

    SubstitutionReasonCode save(Principal principal, substitutionReasonDto) {
        substitutionReasonApplicationService.save(substitutionReasonDto)
    }

    SubstitutionReasonDto findBySubstitutionReasonCode(Principal principal, SubstitutionReasonCode substitutionReasonCode) {
        substitutionReasonApplicationService.findBySubstitutionReasonCode(substitutionReasonCode)
    }

    SubstitutionReasonDto findByIdentifier(Principal principal, Identifier identifier) {
        substitutionReasonApplicationService.findByIdentifier(identifier)
    }

}
