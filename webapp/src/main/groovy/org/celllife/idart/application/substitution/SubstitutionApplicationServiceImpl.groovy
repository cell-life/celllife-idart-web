package org.celllife.idart.application.substitution

import org.celllife.idart.application.substitution.dto.SubstitutionDto
import org.celllife.idart.common.SubstitutionCode
import org.celllife.idart.domain.identifiable.Identifiable
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.identifiable.Identifier
import org.celllife.idart.domain.substitution.SubstitutionNotFoundException
import org.celllife.idart.domain.substitution.SubstitutionService

import static org.celllife.idart.application.substitution.dto.SubstitutionDtoAssembler.toSubstitution
import static org.celllife.idart.application.substitution.dto.SubstitutionDtoAssembler.toSubstitutionDto
import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.SubstitutionCode.substitutionCode
import static org.celllife.idart.domain.identifiable.IdentifiableType.SUBSTITUTION
import static org.celllife.idart.domain.identifiable.Identifiers.newIdentifier

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class SubstitutionApplicationServiceImpl implements SubstitutionApplicationService {

    @Inject SubstitutionService substitutionService   

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(SubstitutionCode substitutionCode) {
        substitutionService.exists(substitutionCode)
    }

    SubstitutionCode save(SubstitutionDto substitutionDto) {

        def substitution = toSubstitution(substitutionDto)

        def identifiable = identifiableService.findByIdentifiers(SUBSTITUTION, substitutionDto.identifiers)
        if (identifiable == null) {

            substitution = substitutionService.save(substitution)

            identifiable = new Identifiable(type: SUBSTITUTION, identifiers: substitutionDto.identifiers)
            identifiable.addIdentifier(newIdentifier(IDART, substitution.id.value))
            identifiableService.save(identifiable)

        } else {

            substitution.id = substitutionCode(identifiable.getIdentifier(IDART).value)
            substitutionService.save(substitution)

        }

        substitution.id
    }

    @Override
    SubstitutionDto findBySubstitutionCode(SubstitutionCode substitutionCode) {
        def identifier = newIdentifier(IDART, substitutionCode.value)
        findByIdentifier(identifier)
    }

    @Override
    SubstitutionDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.findByIdentifiers(SUBSTITUTION, [identifier] as Set)

        if (identifiable == null) {
            throw new SubstitutionNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def substitutionCode = substitutionCode(identifiable.getIdentifier(IDART).value)

        def substitution = substitutionService.findBySubstitutionCode(substitutionCode)

        def substitutionDto = toSubstitutionDto(substitution)
        substitutionDto.identifiers = identifiable.identifiers

        substitutionDto
    }
}
