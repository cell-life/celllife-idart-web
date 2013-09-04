package org.celllife.idart.security.substitution

import org.celllife.idart.common.SubstitutionCode
import org.celllife.idart.domain.substitution.Substitution
import org.celllife.idart.application.substitution.SubstitutionApplicationService

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named
import java.security.Principal

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class SubstitutionSecurityAdapter {

    @Inject SubstitutionApplicationService substitutionApplicationService

    Substitution save(Principal principal, Substitution substitution) {
        substitutionApplicationService.save(substitution)
    }

    Substitution findBySubstitutionCode(Principal principal, SubstitutionCode substitutionCode) {
        substitutionApplicationService.findBySubstitutionCode(substitutionCode)
    }

}
