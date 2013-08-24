package org.celllife.idart.domain.substitution

import org.celllife.idart.common.SubstitutionCode

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SubstitutionService {

    Substitution save(Substitution substitution) throws SubstitutionValidationException

    Substitution findBySubstitutionCode(SubstitutionCode substitutionCode) throws SubstitutionNotFoundException

}
