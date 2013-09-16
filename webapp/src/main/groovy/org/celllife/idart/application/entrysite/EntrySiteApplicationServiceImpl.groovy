package org.celllife.idart.application.entrysite

import org.celllife.idart.application.entrysite.dto.EntrySiteDto
import org.celllife.idart.application.entrysite.dto.EntrySiteDtoAssembler
import org.celllife.idart.common.EntrySiteCode
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.common.Identifier
import org.celllife.idart.domain.entrysite.EntrySiteNotFoundException
import org.celllife.idart.domain.entrysite.EntrySiteService

import static org.celllife.idart.common.SystemId.IDART_WEB
import static org.celllife.idart.common.EntrySiteCode.entrySiteCode
import static org.celllife.idart.common.IdentifiableType.ENTRY_SITE
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.Identifiers.getIdentifierValue

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class EntrySiteApplicationServiceImpl implements EntrySiteApplicationService {

    @Inject EntrySiteService entrySiteService   

    @Inject EntrySiteDtoAssembler entrySiteDtoAssembler

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(EntrySiteCode entrySiteCode) {
        entrySiteService.exists(entrySiteCode)
    }

    @Override
    EntrySiteCode save(EntrySiteDto entrySiteDto) {

        def identifiable = identifiableService.resolveIdentifiable(ENTRY_SITE, entrySiteDto.identifiers)

        def entrySiteCode = entrySiteCode(identifiable.getIdentifierValue(IDART_WEB))

        def entrySite = entrySiteDtoAssembler.toEntrySite(entrySiteDto)
        entrySite.id = entrySiteCode

        entrySiteService.save(entrySite)

        entrySite.id
    }

    @Override
    EntrySiteDto findByEntrySiteCode(EntrySiteCode entrySiteCode) {
        def identifier = newIdentifier(IDART_WEB, entrySiteCode.value)
        findByIdentifier(identifier)
    }

    @Override
    EntrySiteDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.resolveIdentifiable(ENTRY_SITE, [identifier] as Set)

        if (identifiable == null) {
            throw new EntrySiteNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def entrySiteCode = entrySiteCode(identifiable.getIdentifierValue(IDART_WEB))

        def entrySite = entrySiteService.findByEntrySiteCode(entrySiteCode)

        def entrySiteDto = entrySiteDtoAssembler.toEntrySiteDto(entrySite)
        entrySiteDto.identifiers = identifiable.identifiers

        entrySiteDto
    }

    @Override
    EntrySiteCode findByIdentifiers(Set<Identifier> identifiers) {

        def identifiable = identifiableService.resolveIdentifiable(ENTRY_SITE, identifiers)

        def idartIdentifierValue = getIdentifierValue(identifiable.identifiers, IDART_WEB)

        entrySiteCode(idartIdentifierValue)
    }
}
