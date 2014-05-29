package org.celllife.idart.application.part

import org.celllife.idart.application.part.dto.CompoundDto
import org.celllife.idart.application.part.dto.PartDto
import org.celllife.idart.application.part.dto.PartDtoAssembler
import org.celllife.idart.common.PartId
import org.celllife.idart.common.PartType
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.common.Identifier
import org.celllife.idart.domain.part.PartNotFoundException
import org.celllife.idart.domain.part.PartService

import static org.celllife.idart.common.PartId.partId
import static org.celllife.idart.common.IdentifiableType.PART
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.Identifiers.getIdentifierValue
import static org.celllife.idart.common.Systems.IDART_WEB

import javax.inject.Inject
import javax.inject.Named

import org.springframework.transaction.annotation.Transactional

/**
 */
@Named class PartApplicationServiceImpl implements PartApplicationService {

    @Inject PartService partService   

    @Inject PartDtoAssembler partDtoAssembler

    @Inject IdentifiableService identifiableService

    @Override
    @Transactional(readOnly = true)
    Boolean exists(PartId partId) {
        partService.exists(partId)
    }

    @Override
    @Transactional
    PartId save(PartDto partDto) {

        def existingPartId = findMatchingPart(partDto)
        if (existingPartId != null) {
            partDto.identifiers << newIdentifier(existingPartId.value)
        }

        def identifiable = identifiableService.resolveIdentifiable(PART, partDto.identifiers)
        partDto.identifiers = identifiable.identifiers

        def partId = partId(identifiable.getIdentifierValue(IDART_WEB.id))

        def part = partDtoAssembler.toPart(partDto)
        part.id = partId

        partService.save(part)

        part.id
    }

    private PartId findMatchingPart(PartDto partDto) {

        if (partDto instanceof CompoundDto) {
            if (partDto.label != null) {
                return partService.findByLabel(partDto.label)
            }
        }

        null
    }

    @Override
    @Transactional(readOnly = true)
    PartDto findByPartId(PartId partId) {
        def identifier = newIdentifier(partId.value)
        findByIdentifier(identifier)
    }

    @Override
    @Transactional(readOnly = true)
    PartDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.findByIdentifiers(PART, [identifier] as Set)
        if (identifiable == null) {
            throw new PartNotFoundException("Could not find Part with id [${identifier}]")
        }

        def partId = partId(identifiable.getIdentifierValue(IDART_WEB.id))

        def part = partService.findByPartId(partId)

        def partDto = partDtoAssembler.toPartDto(part)
        partDto.identifiers = identifiable.identifiers

        partDto
    }

    @Override
    @Transactional(readOnly = true)
    PartId findByIdentifiers(Set<Identifier> identifiers) {

        def identifiable = identifiableService.findByIdentifiers(PART, identifiers)
        if (identifiable == null) {
            throw new PartNotFoundException("Could not find Part with id [${identifiers}]")
        }

        def idartIdentifierValue = getIdentifierValue(identifiable.identifiers, IDART_WEB.id)

        partId(idartIdentifierValue)
    }

    @Override
    @Transactional(readOnly = true)
    Set<PartDto> findByType(PartType type) {

        def partIds = partService.findByType(type)

        partIds.collect { partId -> findByPartId(partId) }
    }
}