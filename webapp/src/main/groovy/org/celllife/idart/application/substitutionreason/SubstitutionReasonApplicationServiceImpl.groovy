package org.celllife.idart.application.substitutionreason

import org.celllife.idart.application.substitutionreason.dto.SubstitutionReasonDto
import org.celllife.idart.application.substitutionreason.dto.SubstitutionReasonDtoAssembler
import org.celllife.idart.common.SubstitutionReasonCode
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.common.Identifier
import org.celllife.idart.domain.substitutionreason.SubstitutionReasonNotFoundException
import org.celllife.idart.domain.substitutionreason.SubstitutionReasonService

import static org.celllife.idart.common.SubstitutionReasonCode.substitutionReasonCode
import static org.celllife.idart.common.IdentifiableType.SUBSTITUTION_REASON
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.Identifiers.getIdentifierValue
import static org.celllife.idart.common.SystemId.IDART_WEB

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class SubstitutionReasonApplicationServiceImpl implements SubstitutionReasonApplicationService {

    @Inject SubstitutionReasonService substitutionReasonService   

    @Inject SubstitutionReasonDtoAssembler substitutionReasonDtoAssembler

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(SubstitutionReasonCode substitutionReasonCode) {
        substitutionReasonService.exists(substitutionReasonCode)
    }

    @Override
    SubstitutionReasonCode save(SubstitutionReasonDto substitutionReasonDto) {

        def identifiable = identifiableService.resolveIdentifiable(SUBSTITUTION_REASON, substitutionReasonDto.identifiers)
        substitutionReasonDto.identifiers = identifiable.identifiers

        def substitutionReasonCode = substitutionReasonCode(identifiable.getIdentifierValue(IDART_WEB))

        def substitutionReason = substitutionReasonDtoAssembler.toSubstitutionReason(substitutionReasonDto)
        substitutionReason.id = substitutionReasonCode

        substitutionReasonService.save(substitutionReason)

        substitutionReason.id
    }

    @Override
    SubstitutionReasonDto findBySubstitutionReasonCode(SubstitutionReasonCode substitutionReasonCode) {
        def identifier = newIdentifier(IDART_WEB, substitutionReasonCode.value)
        findByIdentifier(identifier)
    }

    @Override
    SubstitutionReasonDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.resolveIdentifiable(SUBSTITUTION_REASON, [identifier] as Set)

        if (identifiable == null) {
            throw new SubstitutionReasonNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def substitutionReasonCode = substitutionReasonCode(identifiable.getIdentifierValue(IDART_WEB))

        def substitutionReason = substitutionReasonService.findBySubstitutionReasonCode(substitutionReasonCode)

        def substitutionReasonDto = substitutionReasonDtoAssembler.toSubstitutionReasonDto(substitutionReason)
        substitutionReasonDto.identifiers = identifiable.identifiers

        substitutionReasonDto
    }

    @Override
    SubstitutionReasonCode findByIdentifiers(Set<Identifier> identifiers) {

        def identifiable = identifiableService.resolveIdentifiable(SUBSTITUTION_REASON, identifiers)

        def idartIdentifierValue = getIdentifierValue(identifiable.identifiers, IDART_WEB)

        substitutionReasonCode(idartIdentifierValue)
    }
}
