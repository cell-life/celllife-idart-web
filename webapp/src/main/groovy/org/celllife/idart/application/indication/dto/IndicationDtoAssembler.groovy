package org.celllife.idart.application.indication.dto

import org.celllife.idart.domain.indication.Indication
import org.celllife.idart.common.Identifier

import javax.annotation.Generated
import javax.inject.Named
import javax.inject.Inject

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class IndicationDtoAssembler {

    Indication toIndication(IndicationDto indicationDto) {

        def indication = new Indication()
        indication.with {

        }

        indication
    }

    IndicationDto toIndicationDto(Indication indication) {

        def indicationDto = new IndicationDto()
        indicationDto.with {

        }

        indicationDto
    }
}
