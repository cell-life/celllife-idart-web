package org.celllife.idart.application.substitutionreason

import org.celllife.idart.domain.substitutionreason.SubstitutionReason
import org.celllife.idart.domain.substitutionreason.SubstitutionReasonValidationException
import org.celllife.idart.domain.substitutionreason.SubstitutionReasonNotFoundException
import org.celllife.idart.common.SubstitutionReasonCode

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface SubstitutionReasonApplicationService {

    SubstitutionReason save(SubstitutionReason substitutionReason) throws SubstitutionReasonValidationException

    SubstitutionReason findBySubstitutionReasonCode(SubstitutionReasonCode substitutionReasonCode) throws SubstitutionReasonNotFoundException

}