package org.celllife.idart.application.substitution

import org.celllife.idart.common.SubstitutionCode
import org.celllife.idart.domain.substitution.Substitution

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface SubstitutionApplicationService {

    Substitution save(Substitution substitution)

    Substitution findBySubstitutionCode(SubstitutionCode substitutionCode)

}
