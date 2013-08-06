package org.celllife.idart.domain.substitutionreason

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SubstitutionReasonRepository {

    SubstitutionReason save(SubstitutionReason substitutionReason)

    SubstitutionReason findOne(SubstitutionReasonCode code)

}
