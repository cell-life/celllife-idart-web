package org.celllife.idart.domain.substitution

import org.celllife.idart.common.SubstitutionCode

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SubstitutionRepository {

    Substitution save(Substitution substitution)

    Substitution findOne(SubstitutionCode substitutionCode)

}
