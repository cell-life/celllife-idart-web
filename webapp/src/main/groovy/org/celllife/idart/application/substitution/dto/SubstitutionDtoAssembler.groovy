package org.celllife.idart.application.substitution.dto

import org.celllife.idart.domain.substitution.Substitution
import org.celllife.idart.common.Identifier

import javax.annotation.Generated
import javax.inject.Named
import javax.inject.Inject

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class SubstitutionDtoAssembler {

    Substitution toSubstitution(SubstitutionDto substitutionDto) {

        def substitution = new Substitution()
        substitution.with {

        }

        substitution
    }

    SubstitutionDto toSubstitutionDto(Substitution substitution) {

        def substitutionDto = new SubstitutionDto()
        substitutionDto.with {

        }

        substitutionDto
    }
}
