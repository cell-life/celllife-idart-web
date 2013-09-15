package org.celllife.idart.application.substitutionreason

import org.celllife.idart.application.substitutionreason.dto.SubstitutionReasonDto
import org.celllife.idart.common.SubstitutionReasonCode
import org.celllife.idart.domain.identifiable.Identifiable
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.identifiable.Identifier
import org.celllife.idart.domain.substitutionreason.SubstitutionReasonNotFoundException
import org.celllife.idart.domain.substitutionreason.SubstitutionReasonService

import static org.celllife.idart.application.substitutionreason.dto.SubstitutionReasonDtoAssembler.toSubstitutionReason
import static org.celllife.idart.application.substitutionreason.dto.SubstitutionReasonDtoAssembler.toSubstitutionReasonDto
import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.SubstitutionReasonCode.substitutionReasonCode
import static org.celllife.idart.domain.identifiable.IdentifiableType.SUBSTITUTION_REASON
import static org.celllife.idart.domain.identifiable.Identifiers.newIdentifier

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class SubstitutionReasonApplicationServiceImpl implements SubstitutionReasonApplicationService {

    @Inject SubstitutionReasonService substitutionReasonService   

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(SubstitutionReasonCode substitutionReasonCode) {
        substitutionReasonService.exists(substitutionReasonCode)
    }

    SubstitutionReasonCode save(SubstitutionReasonDto substitutionReasonDto) {

        def substitutionReason = toSubstitutionReason(substitutionReasonDto)

        def identifiable = identifiableService.findByIdentifiers(SUBSTITUTION_REASON, substitutionReasonDto.identifiers)
        if (identifiable == null) {

            substitutionReason = substitutionReasonService.save(substitutionReason)

            identifiable = new Identifiable(type: SUBSTITUTION_REASON, identifiers: substitutionReasonDto.identifiers)
            identifiable.addIdentifier(newIdentifier(IDART, substitutionReason.id.value))
            identifiableService.save(identifiable)

        } else {

            substitutionReason.id = substitutionReasonCode(identifiable.getIdentifier(IDART).value)
            substitutionReasonService.save(substitutionReason)

        }

        substitutionReason.id
    }

    @Override
    SubstitutionReasonDto findBySubstitutionReasonCode(SubstitutionReasonCode substitutionReasonCode) {
        def identifier = newIdentifier(IDART, substitutionReasonCode.value)
        findByIdentifier(identifier)
    }

    @Override
    SubstitutionReasonDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.findByIdentifiers(SUBSTITUTION_REASON, [identifier] as Set)

        if (identifiable == null) {
            throw new SubstitutionReasonNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def substitutionReasonCode = substitutionReasonCode(identifiable.getIdentifier(IDART).value)

        def substitutionReason = substitutionReasonService.findBySubstitutionReasonCode(substitutionReasonCode)

        def substitutionReasonDto = toSubstitutionReasonDto(substitutionReason)
        substitutionReasonDto.identifiers = identifiable.identifiers

        substitutionReasonDto
    }
}
