package org.celllife.idart.application.defaultdosageinstruction

import org.celllife.idart.application.defaultdosageinstruction.dto.DefaultDosageInstructionDto
import org.celllife.idart.common.DefaultDosageInstructionId
import org.celllife.idart.domain.identifiable.Identifiable
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.identifiable.Identifier
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionNotFoundException
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionService

import static org.celllife.idart.application.defaultdosageinstruction.dto.DefaultDosageInstructionDtoAssembler.toDefaultDosageInstruction
import static org.celllife.idart.application.defaultdosageinstruction.dto.DefaultDosageInstructionDtoAssembler.toDefaultDosageInstructionDto
import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.DefaultDosageInstructionId.defaultDosageInstructionId
import static org.celllife.idart.domain.identifiable.IdentifiableType.DEFAULT_DOSAGE_INSTRUCTION
import static org.celllife.idart.domain.identifiable.Identifiers.newIdentifier

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class DefaultDosageInstructionApplicationServiceImpl implements DefaultDosageInstructionApplicationService {

    @Inject DefaultDosageInstructionService defaultDosageInstructionService   

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(DefaultDosageInstructionId defaultDosageInstructionId) {
        defaultDosageInstructionService.exists(defaultDosageInstructionId)
    }

    DefaultDosageInstructionId save(DefaultDosageInstructionDto defaultDosageInstructionDto) {

        def defaultDosageInstruction = toDefaultDosageInstruction(defaultDosageInstructionDto)

        def identifiable = identifiableService.findByIdentifiers(DEFAULT_DOSAGE_INSTRUCTION, defaultDosageInstructionDto.identifiers)
        if (identifiable == null) {

            defaultDosageInstruction = defaultDosageInstructionService.save(defaultDosageInstruction)

            identifiable = new Identifiable(type: DEFAULT_DOSAGE_INSTRUCTION, identifiers: defaultDosageInstructionDto.identifiers)
            identifiable.addIdentifier(newIdentifier(IDART, defaultDosageInstruction.id.value))
            identifiableService.save(identifiable)

        } else {

            defaultDosageInstruction.id = defaultDosageInstructionId(identifiable.getIdentifier(IDART).value)
            defaultDosageInstructionService.save(defaultDosageInstruction)

        }

        defaultDosageInstruction.id
    }

    @Override
    DefaultDosageInstructionDto findByDefaultDosageInstructionId(DefaultDosageInstructionId defaultDosageInstructionId) {
        def identifier = newIdentifier(IDART, defaultDosageInstructionId.value)
        findByIdentifier(identifier)
    }

    @Override
    DefaultDosageInstructionDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.findByIdentifiers(DEFAULT_DOSAGE_INSTRUCTION, [identifier] as Set)

        if (identifiable == null) {
            throw new DefaultDosageInstructionNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def defaultDosageInstructionId = defaultDosageInstructionId(identifiable.getIdentifier(IDART).value)

        def defaultDosageInstruction = defaultDosageInstructionService.findByDefaultDosageInstructionId(defaultDosageInstructionId)

        def defaultDosageInstructionDto = toDefaultDosageInstructionDto(defaultDosageInstruction)
        defaultDosageInstructionDto.identifiers = identifiable.identifiers

        defaultDosageInstructionDto
    }
}
