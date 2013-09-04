package org.celllife.idart.application.substitutionreason

import org.celllife.idart.common.SubstitutionReasonCode
import org.celllife.idart.domain.substitutionreason.SubstitutionReason

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface SubstitutionReasonApplicationService {

    SubstitutionReason save(SubstitutionReason substitutionReason)

    SubstitutionReason findBySubstitutionReasonCode(SubstitutionReasonCode substitutionReasonCode)

}
