package org.celllife.idart.security.substitutionreason

import org.celllife.idart.common.SubstitutionReasonCode
import org.celllife.idart.domain.substitutionreason.SubstitutionReason
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

    SubstitutionReason save(Principal principal, SubstitutionReason substitutionReason) {
        substitutionReasonApplicationService.save(substitutionReason)
    }

    SubstitutionReason findBySubstitutionReasonCode(Principal principal, SubstitutionReasonCode substitutionReasonCode) {
        substitutionReasonApplicationService.findBySubstitutionReasonCode(substitutionReasonCode)
    }

}
