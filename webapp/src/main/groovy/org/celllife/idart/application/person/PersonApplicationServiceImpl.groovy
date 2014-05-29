package org.celllife.idart.application.person

import org.celllife.idart.application.person.dto.PersonDto
import org.celllife.idart.application.person.dto.PersonDtoAssembler
import org.celllife.idart.common.PersonId
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.common.Identifier
import org.celllife.idart.domain.person.PersonNotFoundException
import org.celllife.idart.domain.person.PersonService

import static org.celllife.idart.common.PersonId.personId
import static org.celllife.idart.common.IdentifiableType.PERSON
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.Identifiers.getIdentifierValue
import static org.celllife.idart.common.Systems.IDART_WEB

import javax.inject.Inject
import javax.inject.Named

import org.springframework.transaction.annotation.Transactional

/**
 */
@Named class PersonApplicationServiceImpl implements PersonApplicationService {

    @Inject PersonService personService   

    @Inject PersonDtoAssembler personDtoAssembler

    @Inject IdentifiableService identifiableService

    @Override
    @Transactional(readOnly = true)
    Boolean exists(PersonId personId) {
        personService.exists(personId)
    }

    @Override
    @Transactional
    PersonId save(PersonDto personDto) {

        def identifiable = identifiableService.resolveIdentifiable(PERSON, personDto.identifiers)
        personDto.identifiers = identifiable.identifiers

        def personId = personId(identifiable.getIdentifierValue(IDART_WEB.id))

        def person = personDtoAssembler.toPerson(personDto)
        person.id = personId

        personService.save(person)

        person.id
    }

    @Override
    @Transactional(readOnly = true)
    PersonDto findByPersonId(PersonId personId) {
        def identifier = newIdentifier(personId.value)
        findByIdentifier(identifier)
    }

    @Override
    @Transactional(readOnly = true)
    PersonDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.findByIdentifiers(PERSON, [identifier] as Set)
        if (identifiable == null) {
            throw new PersonNotFoundException("Could not find Person with id [${identifier}]")
        }

        def personId = personId(identifiable.getIdentifierValue(IDART_WEB.id))

        def person = personService.findByPersonId(personId)

        def personDto = personDtoAssembler.toPersonDto(person)
        personDto.identifiers = identifiable.identifiers

        personDto
    }

    @Override
    @Transactional(readOnly = true)
    PersonId findByIdentifiers(Set<Identifier> identifiers) {

        def identifiable = identifiableService.findByIdentifiers(PERSON, identifiers)
        if (identifiable == null) {
            throw new PersonNotFoundException("Could not find Person with id [${identifiers}]")
        }

        def idartIdentifierValue = getIdentifierValue(identifiable.identifiers, IDART_WEB.id)

        personId(idartIdentifierValue)
    }
}
