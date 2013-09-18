package org.celllife.idart.application.dispensation.dto

import org.celllife.idart.domain.dispensation.Dispensation
import org.celllife.idart.common.Identifier

import javax.inject.Named
import javax.inject.Inject

/**
 */
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
