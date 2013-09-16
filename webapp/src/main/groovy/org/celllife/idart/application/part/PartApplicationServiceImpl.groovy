package org.celllife.idart.application.part

import org.celllife.idart.application.part.dto.PartDto
import org.celllife.idart.application.part.dto.PartDtoAssembler
import org.celllife.idart.common.PartId
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.common.Identifier
import org.celllife.idart.domain.part.PartNotFoundException
import org.celllife.idart.domain.part.PartService

import static org.celllife.idart.common.SystemId.IDART_WEB
import static org.celllife.idart.common.PartId.partId
import static org.celllife.idart.common.IdentifiableType.PART
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.Identifiers.getIdentifierValue

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class PartApplicationServiceImpl implements PartApplicationService {

    @Inject PartService partService   

    @Inject PartDtoAssembler partDtoAssembler

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(PartId partId) {
        partService.exists(partId)
    }

    @Override
    PartId save(PartDto partDto) {

        def identifiable = identifiableService.resolveIdentifiable(PART, partDto.identifiers)

        def partId = partId(identifiable.getIdentifierValue(IDART_WEB))

        def part = partDtoAssembler.toPart(partDto)
        part.id = partId

        partService.save(part)

        part.id
    }

    @Override
    PartDto findByPartId(PartId partId) {
        def identifier = newIdentifier(IDART_WEB, partId.value)
        findByIdentifier(identifier)
    }

    @Override
    PartDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.resolveIdentifiable(PART, [identifier] as Set)

        if (identifiable == null) {
            throw new PartNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def partId = partId(identifiable.getIdentifierValue(IDART_WEB))

        def part = partService.findByPartId(partId)

        def partDto = partDtoAssembler.toPartDto(part)
        partDto.identifiers = identifiable.identifiers

        partDto
    }

    @Override
    PartId findByIdentifiers(Set<Identifier> identifiers) {

        def identifiable = identifiableService.resolveIdentifiable(PART, identifiers)

        def idartIdentifierValue = getIdentifierValue(identifiable.identifiers, IDART_WEB)

        partId(idartIdentifierValue)
    }
}
