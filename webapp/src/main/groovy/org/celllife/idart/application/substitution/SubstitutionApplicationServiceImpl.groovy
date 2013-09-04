package org.celllife.idart.application.substitution

import org.celllife.idart.common.SubstitutionCode
import org.celllife.idart.domain.substitution.Substitution
import org.celllife.idart.domain.substitution.SubstitutionService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class SubstitutionApplicationServiceImpl implements SubstitutionApplicationService {

    @Inject SubstitutionService substitutionService

    Substitution save(Substitution substitution) {
        substitutionService.save(substitution)
    }

    Substitution findBySubstitutionCode(SubstitutionCode substitutionCode) {
        substitutionService.findBySubstitutionCode(substitutionCode)
    }

}
