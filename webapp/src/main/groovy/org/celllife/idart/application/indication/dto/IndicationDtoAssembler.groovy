package org.celllife.idart.application.indication.dto

import org.celllife.idart.domain.indication.Indication
import org.celllife.idart.domain.identifiable.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
class IndicationDtoAssembler {

    static Indication toIndication(IndicationDto indicationDto) {

        def indication = new Indication()
        indication.with {

        }

        indication
    }

    static IndicationDto toIndicationDto(Indication indication) {

        def indicationDto = new IndicationDto()
        indicationDto.with {

        }

        indicationDto
    }
}
