package org.celllife.idart.security.substitution

import org.celllife.idart.application.substitution.dto.SubstitutionDto
import org.celllife.idart.common.SubstitutionCode
import org.celllife.idart.common.Identifier
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

    SubstitutionCode save(Principal principal, substitutionDto) {
        substitutionApplicationService.save(substitutionDto)
    }

    SubstitutionDto findBySubstitutionCode(Principal principal, SubstitutionCode substitutionCode) {
        substitutionApplicationService.findBySubstitutionCode(substitutionCode)
    }

    SubstitutionDto findByIdentifier(Principal principal, Identifier identifier) {
        substitutionApplicationService.findByIdentifier(identifier)
    }

}
