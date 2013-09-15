package org.celllife.idart.application.dispensation.dto

import org.celllife.idart.domain.dispensation.Dispensation
import org.celllife.idart.domain.identifiable.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class DispensationDtoAssembler {

    static Dispensation toDispensation(DispensationDto dispensationDto) {

        def dispensation = new Dispensation()
        dispensation.with {

        }

        dispensation
    }

    static DispensationDto toDispensationDto(Dispensation dispensation) {

        def dispensationDto = new DispensationDto()
        dispensationDto.with {

        }

        dispensationDto
    }
}
