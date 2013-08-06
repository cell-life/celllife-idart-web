package org.celllife.idart.domain.substitution

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SubstitutionRepository {

    Substitution save(Substitution substitution)

    Substitution findOne(SubstitutionCode code)

}
