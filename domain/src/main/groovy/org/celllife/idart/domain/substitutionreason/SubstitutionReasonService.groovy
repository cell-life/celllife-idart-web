package org.celllife.idart.domain.substitutionreason

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SubstitutionReasonService {

    SubstitutionReason save(SubstitutionReason substitutionReason) throws SubstitutionReasonValidationException

    SubstitutionReason findByCode(SubstitutionReasonCode code) throws SubstitutionReasonNotFoundException

}