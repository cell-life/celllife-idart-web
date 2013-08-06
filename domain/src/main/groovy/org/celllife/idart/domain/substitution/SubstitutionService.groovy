package org.celllife.idart.domain.substitution

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SubstitutionService {

    Substitution save(Substitution substitution) throws SubstitutionValidationException

    Substitution findByCode(SubstitutionCode code) throws SubstitutionNotFoundException

}