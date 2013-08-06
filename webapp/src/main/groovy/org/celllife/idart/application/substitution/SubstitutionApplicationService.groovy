package org.celllife.idart.application.substitution

import org.celllife.idart.domain.substitution.Substitution
import org.celllife.idart.domain.substitution.SubstitutionValidationException
import org.celllife.idart.domain.substitution.SubstitutionNotFoundException
import org.celllife.idart.domain.substitution.SubstitutionCode

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface SubstitutionApplicationService {

    Substitution save(Substitution substitution) throws SubstitutionValidationException

    Substitution findByCode(SubstitutionCode code) throws SubstitutionNotFoundException

}