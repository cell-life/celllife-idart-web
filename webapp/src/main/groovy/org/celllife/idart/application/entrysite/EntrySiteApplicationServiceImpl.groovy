package org.celllife.idart.application.entrysite

import org.celllife.idart.application.entrysite.dto.EntrySiteDto
import org.celllife.idart.common.EntrySiteCode
import org.celllife.idart.domain.identifiable.Identifiable
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.identifiable.Identifier
import org.celllife.idart.domain.entrysite.EntrySiteNotFoundException
import org.celllife.idart.domain.entrysite.EntrySiteService

import static org.celllife.idart.application.entrysite.dto.EntrySiteDtoAssembler.toEntrySite
import static org.celllife.idart.application.entrysite.dto.EntrySiteDtoAssembler.toEntrySiteDto
import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.EntrySiteCode.entrySiteCode
import static org.celllife.idart.domain.identifiable.IdentifiableType.ENTRY_SITE
import static org.celllife.idart.domain.identifiable.Identifiers.newIdentifier

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class EntrySiteApplicationServiceImpl implements EntrySiteApplicationService {

    @Inject EntrySiteService entrySiteService   

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(EntrySiteCode entrySiteCode) {
        entrySiteService.exists(entrySiteCode)
    }

    EntrySiteCode save(EntrySiteDto entrySiteDto) {

        def entrySite = toEntrySite(entrySiteDto)

        def identifiable = identifiableService.findByIdentifiers(ENTRY_SITE, entrySiteDto.identifiers)
        if (identifiable == null) {

            entrySite = entrySiteService.save(entrySite)

            identifiable = new Identifiable(type: ENTRY_SITE, identifiers: entrySiteDto.identifiers)
            identifiable.addIdentifier(newIdentifier(IDART, entrySite.id.value))
            identifiableService.save(identifiable)

        } else {

            entrySite.id = entrySiteCode(identifiable.getIdentifier(IDART).value)
            entrySiteService.save(entrySite)

        }

        entrySite.id
    }

    @Override
    EntrySiteDto findByEntrySiteCode(EntrySiteCode entrySiteCode) {
        def identifier = newIdentifier(IDART, entrySiteCode.value)
        findByIdentifier(identifier)
    }

    @Override
    EntrySiteDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.findByIdentifiers(ENTRY_SITE, [identifier] as Set)

        if (identifiable == null) {
            throw new EntrySiteNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def entrySiteCode = entrySiteCode(identifiable.getIdentifier(IDART).value)

        def entrySite = entrySiteService.findByEntrySiteCode(entrySiteCode)

        def entrySiteDto = toEntrySiteDto(entrySite)
        entrySiteDto.identifiers = identifiable.identifiers

        entrySiteDto
    }
}
