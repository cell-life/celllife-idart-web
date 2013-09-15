package org.celllife.idart.application.person

import org.celllife.idart.application.person.dto.PersonDto
import org.celllife.idart.common.AuthorityId
import org.celllife.idart.common.PersonId
import org.celllife.idart.domain.identifiable.Identifiable
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.identifiable.Identifier
import org.celllife.idart.domain.person.PersonNotFoundException
import org.celllife.idart.domain.person.PersonService

import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.application.person.dto.PersonDtoAssembler.toPerson
import static org.celllife.idart.application.person.dto.PersonDtoAssembler.toPersonDto
import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.PersonId.personId
import static org.celllife.idart.domain.identifiable.IdentifiableType.PERSON
import static org.celllife.idart.domain.identifiable.Identifiers.newIdentifier

/**
 */
@Named class PersonApplicationServiceImpl implements PersonApplicationService {

    @Inject PersonService personService

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(PersonId personId) {
        personService.exists(personId)
    }

    @Override
    PersonId save(PersonDto personDto) {

        def person = toPerson(personDto)

        def identifiable = identifiableService.findByIdentifiers(PERSON, personDto.identifiers)
        if (identifiable == null) {

            person = personService.save(person)

            identifiable = new Identifiable(type: PERSON, identifiers: personDto.identifiers)
            identifiable.addIdentifier(newIdentifier(IDART, person.id.value))
            identifiableService.save(identifiable)

        } else {

            person.id = personId(identifiable.getIdentifier(IDART).value)
            personService.save(person)

        }

        person.id
    }

    @Override
    PersonDto findByPersonId(PersonId personId) {
        def identifier = newIdentifier(IDART, personId.value)
        findByIdentifier(identifier)
    }

    @Override
    PersonDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.findByIdentifiers(PERSON, [identifier] as Set)

        if (identifiable == null) {
            throw new PersonNotFoundException("Could not find Person with id [${identifier.value}]")
        }

        def personId = personId(identifiable.getIdentifier(IDART).value)

        def person = personService.findByPersonId(personId)

        def personDto = toPersonDto(person)
        personDto.identifiers = identifiable.identifiers

        personDto
    }
}
