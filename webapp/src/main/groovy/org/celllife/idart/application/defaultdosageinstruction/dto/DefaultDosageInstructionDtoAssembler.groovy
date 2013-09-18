package org.celllife.idart.application.defaultdosageinstruction.dto

import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstruction
import org.celllife.idart.common.Identifier

import javax.inject.Named
import javax.inject.Inject

/**
 */
@Named class DefaultDosageInstructionDtoAssembler {

    DefaultDosageInstruction toDefaultDosageInstruction(DefaultDosageInstructionDto defaultDosageInstructionDto) {

        def defaultDosageInstruction = new DefaultDosageInstruction()
        defaultDosageInstruction.with {

        }

        defaultDosageInstruction
    }

    DefaultDosageInstructionDto toDefaultDosageInstructionDto(DefaultDosageInstruction defaultDosageInstruction) {

        def defaultDosageInstructionDto = new DefaultDosageInstructionDto()
        defaultDosageInstructionDto.with {

        }

        defaultDosageInstructionDto
    }
}
