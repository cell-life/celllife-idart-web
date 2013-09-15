package org.celllife.idart.application.indication

import org.celllife.idart.application.indication.dto.IndicationDto
import org.celllife.idart.common.IndicationCode
import org.celllife.idart.domain.identifiable.Identifiable
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.identifiable.Identifier
import org.celllife.idart.domain.indication.IndicationNotFoundException
import org.celllife.idart.domain.indication.IndicationService

import static org.celllife.idart.application.indication.dto.IndicationDtoAssembler.toIndication
import static org.celllife.idart.application.indication.dto.IndicationDtoAssembler.toIndicationDto
import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.IndicationCode.indicationCode
import static org.celllife.idart.domain.identifiable.IdentifiableType.INDICATION
import static org.celllife.idart.domain.identifiable.Identifiers.newIdentifier

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class IndicationApplicationServiceImpl implements IndicationApplicationService {

    @Inject IndicationService indicationService   

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(IndicationCode indicationCode) {
        indicationService.exists(indicationCode)
    }

    IndicationCode save(IndicationDto indicationDto) {

        def indication = toIndication(indicationDto)

        def identifiable = identifiableService.findByIdentifiers(INDICATION, indicationDto.identifiers)
        if (identifiable == null) {

            indication = indicationService.save(indication)

            identifiable = new Identifiable(type: INDICATION, identifiers: indicationDto.identifiers)
            identifiable.addIdentifier(newIdentifier(IDART, indication.id.value))
            identifiableService.save(identifiable)

        } else {

            indication.id = indicationCode(identifiable.getIdentifier(IDART).value)
            indicationService.save(indication)

        }

        indication.id
    }

    @Override
    IndicationDto findByIndicationCode(IndicationCode indicationCode) {
        def identifier = newIdentifier(IDART, indicationCode.value)
        findByIdentifier(identifier)
    }

    @Override
    IndicationDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.findByIdentifiers(INDICATION, [identifier] as Set)

        if (identifiable == null) {
            throw new IndicationNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def indicationCode = indicationCode(identifiable.getIdentifier(IDART).value)

        def indication = indicationService.findByIndicationCode(indicationCode)

        def indicationDto = toIndicationDto(indication)
        indicationDto.identifiers = identifiable.identifiers

        indicationDto
    }
}
