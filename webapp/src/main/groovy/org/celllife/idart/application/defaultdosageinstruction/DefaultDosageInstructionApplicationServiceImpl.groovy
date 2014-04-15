package org.celllife.idart.application.defaultdosageinstruction

import org.celllife.idart.application.defaultdosageinstruction.dto.DefaultDosageInstructionDto
import org.celllife.idart.application.defaultdosageinstruction.dto.DefaultDosageInstructionDtoAssembler
import org.celllife.idart.common.DefaultDosageInstructionId
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.common.Identifier
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionNotFoundException
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionService

import static org.celllife.idart.common.DefaultDosageInstructionId.defaultDosageInstructionId
import static org.celllife.idart.common.IdentifiableType.DEFAULT_DOSAGE_INSTRUCTION
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.Identifiers.getIdentifierValue
import static org.celllife.idart.common.Identifiers.newIdentifiers
import static org.celllife.idart.common.Systems.IDART_WEB

import javax.inject.Inject
import javax.inject.Named

import org.springframework.transaction.annotation.Transactional

/**
 */
@Named class DefaultDosageInstructionApplicationServiceImpl implements DefaultDosageInstructionApplicationService {

    @Inject DefaultDosageInstructionService defaultDosageInstructionService   

    @Inject DefaultDosageInstructionDtoAssembler defaultDosageInstructionDtoAssembler

    @Inject IdentifiableService identifiableService

    @Override
    @Transactional(readOnly = true)
    Boolean exists(DefaultDosageInstructionId defaultDosageInstructionId) {
        defaultDosageInstructionService.exists(defaultDosageInstructionId)
    }

    @Override
    @Transactional
    DefaultDosageInstructionId save(DefaultDosageInstructionDto defaultDosageInstructionDto) {

        def identifiable = identifiableService.resolveIdentifiable(DEFAULT_DOSAGE_INSTRUCTION, defaultDosageInstructionDto.identifiers)
        defaultDosageInstructionDto.identifiers = identifiable.identifiers

        def defaultDosageInstructionId = defaultDosageInstructionId(identifiable.getIdentifierValue(IDART_WEB.id))

        def defaultDosageInstruction = defaultDosageInstructionDtoAssembler.toDefaultDosageInstruction(defaultDosageInstructionDto)
        defaultDosageInstruction.id = defaultDosageInstructionId

        defaultDosageInstructionService.save(defaultDosageInstruction)

        defaultDosageInstruction.id
    }

    @Override
    @Transactional(readOnly = true)
    DefaultDosageInstructionDto findByDefaultDosageInstructionId(DefaultDosageInstructionId defaultDosageInstructionId) {
        def identifier = newIdentifier(defaultDosageInstructionId.value)
        findByIdentifier(identifier)
    }

    @Override
    @Transactional(readOnly = true)
    DefaultDosageInstructionDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.resolveIdentifiable(DEFAULT_DOSAGE_INSTRUCTION, [identifier] as Set)

        if (identifiable == null) {
            throw new DefaultDosageInstructionNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def defaultDosageInstructionId = defaultDosageInstructionId(identifiable.getIdentifierValue(IDART_WEB.id))

        def defaultDosageInstruction = defaultDosageInstructionService.findByDefaultDosageInstructionId(defaultDosageInstructionId)

        def defaultDosageInstructionDto = defaultDosageInstructionDtoAssembler.toDefaultDosageInstructionDto(defaultDosageInstruction)
        defaultDosageInstructionDto.identifiers = identifiable.identifiers

        defaultDosageInstructionDto
    }

    @Override
    @Transactional(readOnly = true)
    DefaultDosageInstructionId findByIdentifiers(Set<Identifier> identifiers) {

        def identifiable = identifiableService.resolveIdentifiable(DEFAULT_DOSAGE_INSTRUCTION, identifiers)

        def idartIdentifierValue = getIdentifierValue(identifiable.identifiers, IDART_WEB.id)

        defaultDosageInstructionId(idartIdentifierValue)
    }
}