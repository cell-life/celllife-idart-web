package org.celllife.idart.application.substitution.dto

import org.celllife.idart.domain.substitution.Substitution
import org.celllife.idart.domain.identifiable.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class SubstitutionDtoAssembler {

    static Substitution toSubstitution(SubstitutionDto substitutionDto) {

        def substitution = new Substitution()
        substitution.with {

        }

        substitution
    }

    static SubstitutionDto toSubstitutionDto(Substitution substitution) {

        def substitutionDto = new SubstitutionDto()
        substitutionDto.with {

        }

        substitutionDto
    }
}
