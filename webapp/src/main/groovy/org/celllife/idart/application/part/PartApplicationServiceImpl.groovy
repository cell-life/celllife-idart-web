package org.celllife.idart.application.part

import org.celllife.idart.application.part.dto.PartDto
import org.celllife.idart.common.PartId
import org.celllife.idart.domain.identifiable.Identifiable
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.identifiable.Identifier
import org.celllife.idart.domain.part.PartNotFoundException
import org.celllife.idart.domain.part.PartService

import static org.celllife.idart.application.part.dto.PartDtoAssembler.toPart
import static org.celllife.idart.application.part.dto.PartDtoAssembler.toPartDto
import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.PartId.partId
import static org.celllife.idart.domain.identifiable.IdentifiableType.PART
import static org.celllife.idart.domain.identifiable.Identifiers.newIdentifier

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class PartApplicationServiceImpl implements PartApplicationService {

    @Inject PartService partService   

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(PartId partId) {
        partService.exists(partId)
    }

    PartId save(PartDto partDto) {

        def part = toPart(partDto)

        def identifiable = identifiableService.findByIdentifiers(PART, partDto.identifiers)
        if (identifiable == null) {

            part = partService.save(part)

            identifiable = new Identifiable(type: PART, identifiers: partDto.identifiers)
            identifiable.addIdentifier(newIdentifier(IDART, part.id.value))
            identifiableService.save(identifiable)

        } else {

            part.id = partId(identifiable.getIdentifier(IDART).value)
            partService.save(part)

        }

        part.id
    }

    @Override
    PartDto findByPartId(PartId partId) {
        def identifier = newIdentifier(IDART, partId.value)
        findByIdentifier(identifier)
    }

    @Override
    PartDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.findByIdentifiers(PART, [identifier] as Set)

        if (identifiable == null) {
            throw new PartNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def partId = partId(identifiable.getIdentifier(IDART).value)

        def part = partService.findByPartId(partId)

        def partDto = toPartDto(part)
        partDto.identifiers = identifiable.identifiers

        partDto
    }
}
