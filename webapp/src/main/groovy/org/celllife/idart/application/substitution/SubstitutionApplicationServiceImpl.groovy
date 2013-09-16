package org.celllife.idart.application.substitution

import org.celllife.idart.application.substitution.dto.SubstitutionDto
import org.celllife.idart.application.substitution.dto.SubstitutionDtoAssembler
import org.celllife.idart.common.SubstitutionCode
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.common.Identifier
import org.celllife.idart.domain.substitution.SubstitutionNotFoundException
import org.celllife.idart.domain.substitution.SubstitutionService

import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.SubstitutionCode.substitutionCode
import static org.celllife.idart.common.IdentifiableType.SUBSTITUTION
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.Identifiers.getIdentifierValue

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class SubstitutionApplicationServiceImpl implements SubstitutionApplicationService {

    @Inject SubstitutionService substitutionService   

    @Inject SubstitutionDtoAssembler substitutionDtoAssembler

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(SubstitutionCode substitutionCode) {
        substitutionService.exists(substitutionCode)
    }

    @Override
    SubstitutionCode save(SubstitutionDto substitutionDto) {

        def identifiable = identifiableService.resolveIdentifiable(SUBSTITUTION, substitutionDto.identifiers)

        def substitutionCode = substitutionCode(identifiable.getIdentifierValue(IDART))

        def substitution = substitutionDtoAssembler.toSubstitution(substitutionDto)
        substitution.id = substitutionCode

        substitutionService.save(substitution)

        substitution.id
    }

    @Override
    SubstitutionDto findBySubstitutionCode(SubstitutionCode substitutionCode) {
        def identifier = newIdentifier(IDART, substitutionCode.value)
        findByIdentifier(identifier)
    }

    @Override
    SubstitutionDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.resolveIdentifiable(SUBSTITUTION, [identifier] as Set)

        if (identifiable == null) {
            throw new SubstitutionNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def substitutionCode = substitutionCode(identifiable.getIdentifierValue(IDART))

        def substitution = substitutionService.findBySubstitutionCode(substitutionCode)

        def substitutionDto = substitutionDtoAssembler.toSubstitutionDto(substitution)
        substitutionDto.identifiers = identifiable.identifiers

        substitutionDto
    }

    @Override
    SubstitutionCode findByIdentifiers(Set<Identifier> identifiers) {

        def identifiable = identifiableService.resolveIdentifiable(SUBSTITUTION, identifiers)

        def idartIdentifierValue = getIdentifierValue(identifiable.identifiers, IDART)

        substitutionCode(idartIdentifierValue)
    }
}
