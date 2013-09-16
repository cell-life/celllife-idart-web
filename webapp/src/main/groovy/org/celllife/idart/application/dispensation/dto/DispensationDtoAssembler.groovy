package org.celllife.idart.application.dispensation.dto

import org.celllife.idart.domain.dispensation.Dispensation
import org.celllife.idart.common.Identifier

import javax.annotation.Generated
import javax.inject.Named
import javax.inject.Inject

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class DispensationDtoAssembler {

    Dispensation toDispensation(DispensationDto dispensationDto) {

        def dispensation = new Dispensation()
        dispensation.with {

        }

        dispensation
    }

    DispensationDto toDispensationDto(Dispensation dispensation) {

        def dispensationDto = new DispensationDto()
        dispensationDto.with {

        }

        dispensationDto
    }
}
