package org.celllife.idart.application.substitutionreason.dto

import org.celllife.idart.domain.substitutionreason.SubstitutionReason
import org.celllife.idart.domain.identifiable.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class SubstitutionReasonDtoAssembler {

    static SubstitutionReason toSubstitutionReason(SubstitutionReasonDto substitutionReasonDto) {

        def substitutionReason = new SubstitutionReason()
        substitutionReason.with {

        }

        substitutionReason
    }

    static SubstitutionReasonDto toSubstitutionReasonDto(SubstitutionReason substitutionReason) {

        def substitutionReasonDto = new SubstitutionReasonDto()
        substitutionReasonDto.with {

        }

        substitutionReasonDto
    }
}
