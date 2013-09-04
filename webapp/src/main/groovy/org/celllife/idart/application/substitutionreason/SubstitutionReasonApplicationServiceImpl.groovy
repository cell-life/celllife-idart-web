package org.celllife.idart.application.substitutionreason

import org.celllife.idart.common.SubstitutionReasonCode
import org.celllife.idart.domain.substitutionreason.SubstitutionReason
import org.celllife.idart.domain.substitutionreason.SubstitutionReasonService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class SubstitutionReasonApplicationServiceImpl implements SubstitutionReasonApplicationService {

    @Inject SubstitutionReasonService substitutionReasonService

    SubstitutionReason save(SubstitutionReason substitutionReason) {
        substitutionReasonService.save(substitutionReason)
    }

    SubstitutionReason findBySubstitutionReasonCode(SubstitutionReasonCode substitutionReasonCode) {
        substitutionReasonService.findBySubstitutionReasonCode(substitutionReasonCode)
    }

}
