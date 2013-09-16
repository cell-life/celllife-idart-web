package org.celllife.idart.application.person

import org.celllife.idart.application.person.dto.PersonDto
import org.celllife.idart.application.person.dto.PersonDtoAssembler
import org.celllife.idart.common.PersonId
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.common.Identifier
import org.celllife.idart.domain.person.PersonNotFoundException
import org.celllife.idart.domain.person.PersonService

import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.PersonId.personId
import static org.celllife.idart.common.IdentifiableType.PERSON
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.Identifiers.getIdentifierValue

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class PersonApplicationServiceImpl implements PersonApplicationService {

    @Inject PersonService personService   

    @Inject PersonDtoAssembler personDtoAssembler

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(PersonId personId) {
        personService.exists(personId)
    }

    @Override
    PersonId save(PersonDto personDto) {

        def identifiable = identifiableService.resolveIdentifiable(PERSON, personDto.identifiers)

        def personId = personId(identifiable.getIdentifierValue(IDART))

        def person = personDtoAssembler.toPerson(personDto)
        person.id = personId

        personService.save(person)

        person.id
    }

    @Override
    PersonDto findByPersonId(PersonId personId) {
        def identifier = newIdentifier(IDART, personId.value)
        findByIdentifier(identifier)
    }

    @Override
    PersonDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.resolveIdentifiable(PERSON, [identifier] as Set)

        if (identifiable == null) {
            throw new PersonNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def personId = personId(identifiable.getIdentifierValue(IDART))

        def person = personService.findByPersonId(personId)

        def personDto = personDtoAssembler.toPersonDto(person)
        personDto.identifiers = identifiable.identifiers

        personDto
    }

    @Override
    PersonId findByIdentifiers(Set<Identifier> identifiers) {

        def identifiable = identifiableService.resolveIdentifiable(PERSON, identifiers)

        def idartIdentifierValue = getIdentifierValue(identifiable.identifiers, IDART)

        personId(idartIdentifierValue)
    }
}
