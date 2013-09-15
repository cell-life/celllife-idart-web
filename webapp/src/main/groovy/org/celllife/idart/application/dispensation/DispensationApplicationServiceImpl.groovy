package org.celllife.idart.application.dispensation

import org.celllife.idart.application.dispensation.dto.DispensationDto
import org.celllife.idart.common.DispensationId
import org.celllife.idart.domain.identifiable.Identifiable
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.identifiable.Identifier
import org.celllife.idart.domain.dispensation.DispensationNotFoundException
import org.celllife.idart.domain.dispensation.DispensationService

import static org.celllife.idart.application.dispensation.dto.DispensationDtoAssembler.toDispensation
import static org.celllife.idart.application.dispensation.dto.DispensationDtoAssembler.toDispensationDto
import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.DispensationId.dispensationId
import static org.celllife.idart.domain.identifiable.IdentifiableType.DISPENSATION
import static org.celllife.idart.domain.identifiable.Identifiers.newIdentifier

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class DispensationApplicationServiceImpl implements DispensationApplicationService {

    @Inject DispensationService dispensationService   

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(DispensationId dispensationId) {
        dispensationService.exists(dispensationId)
    }

    DispensationId save(DispensationDto dispensationDto) {

        def dispensation = toDispensation(dispensationDto)

        def identifiable = identifiableService.findByIdentifiers(DISPENSATION, dispensationDto.identifiers)
        if (identifiable == null) {

            dispensation = dispensationService.save(dispensation)

            identifiable = new Identifiable(type: DISPENSATION, identifiers: dispensationDto.identifiers)
            identifiable.addIdentifier(newIdentifier(IDART, dispensation.id.value))
            identifiableService.save(identifiable)

        } else {

            dispensation.id = dispensationId(identifiable.getIdentifier(IDART).value)
            dispensationService.save(dispensation)

        }

        dispensation.id
    }

    @Override
    DispensationDto findByDispensationId(DispensationId dispensationId) {
        def identifier = newIdentifier(IDART, dispensationId.value)
        findByIdentifier(identifier)
    }

    @Override
    DispensationDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.findByIdentifiers(DISPENSATION, [identifier] as Set)

        if (identifiable == null) {
            throw new DispensationNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def dispensationId = dispensationId(identifiable.getIdentifier(IDART).value)

        def dispensation = dispensationService.findByDispensationId(dispensationId)

        def dispensationDto = toDispensationDto(dispensation)
        dispensationDto.identifiers = identifiable.identifiers

        dispensationDto
    }
}
