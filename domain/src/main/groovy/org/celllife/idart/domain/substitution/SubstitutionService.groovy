package org.celllife.idart.domain.substitution

import org.celllife.idart.common.SubstitutionCode

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SubstitutionService {

    Boolean exists(SubstitutionCode substitutionCode)

    Substitution save(Substitution substitution)

    Substitution findBySubstitutionCode(SubstitutionCode substitutionCode)

}
