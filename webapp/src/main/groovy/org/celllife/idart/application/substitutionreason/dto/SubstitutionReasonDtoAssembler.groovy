package org.celllife.idart.application.substitutionreason.dto

import org.celllife.idart.domain.substitutionreason.SubstitutionReason
import org.celllife.idart.common.Identifier

import javax.annotation.Generated
import javax.inject.Named
import javax.inject.Inject

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class SubstitutionReasonDtoAssembler {

    SubstitutionReason toSubstitutionReason(SubstitutionReasonDto substitutionReasonDto) {

        def substitutionReason = new SubstitutionReason()
        substitutionReason.with {

        }

        substitutionReason
    }

    SubstitutionReasonDto toSubstitutionReasonDto(SubstitutionReason substitutionReason) {

        def substitutionReasonDto = new SubstitutionReasonDto()
        substitutionReasonDto.with {

        }

        substitutionReasonDto
    }
}
