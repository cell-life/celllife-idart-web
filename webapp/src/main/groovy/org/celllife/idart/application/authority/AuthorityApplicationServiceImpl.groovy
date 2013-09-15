package org.celllife.idart.application.authority

import org.celllife.idart.application.authority.dto.AuthorityDto
import org.celllife.idart.common.AuthorityId
import org.celllife.idart.domain.identifiable.Identifiable
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.identifiable.Identifier
import org.celllife.idart.domain.authority.AuthorityNotFoundException
import org.celllife.idart.domain.authority.AuthorityService

import static org.celllife.idart.application.authority.dto.AuthorityDtoAssembler.toAuthority
import static org.celllife.idart.application.authority.dto.AuthorityDtoAssembler.toAuthorityDto
import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.AuthorityId.authorityId
import static org.celllife.idart.domain.identifiable.IdentifiableType.AUTHORITY
import static org.celllife.idart.domain.identifiable.Identifiers.newIdentifier

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class AuthorityApplicationServiceImpl implements AuthorityApplicationService {

    @Inject AuthorityService authorityService   

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(AuthorityId authorityId) {
        authorityService.exists(authorityId)
    }

    AuthorityId save(AuthorityDto authorityDto) {

        def authority = toAuthority(authorityDto)

        def identifiable = identifiableService.findByIdentifiers(AUTHORITY, authorityDto.identifiers)
        if (identifiable == null) {

            authority = authorityService.save(authority)

            identifiable = new Identifiable(type: AUTHORITY, identifiers: authorityDto.identifiers)
            identifiable.addIdentifier(newIdentifier(IDART, authority.id.value))
            identifiableService.save(identifiable)

        } else {

            authority.id = authorityId(identifiable.getIdentifier(IDART).value)
            authorityService.save(authority)

        }

        authority.id
    }

    @Override
    AuthorityDto findByAuthorityId(AuthorityId authorityId) {
        def identifier = newIdentifier(IDART, authorityId.value)
        findByIdentifier(identifier)
    }

    @Override
    AuthorityDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.findByIdentifiers(AUTHORITY, [identifier] as Set)

        if (identifiable == null) {
            throw new AuthorityNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def authorityId = authorityId(identifiable.getIdentifier(IDART).value)

        def authority = authorityService.findByAuthorityId(authorityId)

        def authorityDto = toAuthorityDto(authority)
        authorityDto.identifiers = identifiable.identifiers

        authorityDto
    }
}
