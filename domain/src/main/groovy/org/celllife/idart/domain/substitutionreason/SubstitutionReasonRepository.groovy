package org.celllife.idart.domain.substitutionreason

import org.celllife.idart.common.SubstitutionReasonCode

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SubstitutionReasonRepository {

    boolean exists(SubstitutionReasonCode substitutionReasonCode)

    SubstitutionReason save(SubstitutionReason substitutionReason)

    SubstitutionReason findOne(SubstitutionReasonCode substitutionReasonCode)

}
