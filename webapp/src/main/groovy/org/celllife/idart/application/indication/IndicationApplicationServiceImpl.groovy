package org.celllife.idart.application.indication

import org.celllife.idart.application.indication.dto.IndicationDto
import org.celllife.idart.application.indication.dto.IndicationDtoAssembler
import org.celllife.idart.common.IndicationCode
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.common.Identifier
import org.celllife.idart.domain.indication.IndicationNotFoundException
import org.celllife.idart.domain.indication.IndicationService

import static org.celllife.idart.common.SystemId.IDART_WEB
import static org.celllife.idart.common.IndicationCode.indicationCode
import static org.celllife.idart.common.IdentifiableType.INDICATION
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.Identifiers.getIdentifierValue

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class IndicationApplicationServiceImpl implements IndicationApplicationService {

    @Inject IndicationService indicationService   

    @Inject IndicationDtoAssembler indicationDtoAssembler

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(IndicationCode indicationCode) {
        indicationService.exists(indicationCode)
    }

    @Override
    IndicationCode save(IndicationDto indicationDto) {

        def identifiable = identifiableService.resolveIdentifiable(INDICATION, indicationDto.identifiers)

        def indicationCode = indicationCode(identifiable.getIdentifierValue(IDART_WEB))

        def indication = indicationDtoAssembler.toIndication(indicationDto)
        indication.id = indicationCode

        indicationService.save(indication)

        indication.id
    }

    @Override
    IndicationDto findByIndicationCode(IndicationCode indicationCode) {
        def identifier = newIdentifier(IDART_WEB, indicationCode.value)
        findByIdentifier(identifier)
    }

    @Override
    IndicationDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.resolveIdentifiable(INDICATION, [identifier] as Set)

        if (identifiable == null) {
            throw new IndicationNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def indicationCode = indicationCode(identifiable.getIdentifierValue(IDART_WEB))

        def indication = indicationService.findByIndicationCode(indicationCode)

        def indicationDto = indicationDtoAssembler.toIndicationDto(indication)
        indicationDto.identifiers = identifiable.identifiers

        indicationDto
    }

    @Override
    IndicationCode findByIdentifiers(Set<Identifier> identifiers) {

        def identifiable = identifiableService.resolveIdentifiable(INDICATION, identifiers)

        def idartIdentifierValue = getIdentifierValue(identifiable.identifiers, IDART_WEB)

        indicationCode(idartIdentifierValue)
    }
}
