package org.celllife.idart.application.person

import org.celllife.idart.application.person.dto.PersonDto
import org.celllife.idart.common.PersonId
import org.celllife.idart.domain.identifiable.Identifiable
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.person.Person
import org.celllife.idart.domain.person.PersonService

import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.application.person.dto.PersonDtoAssembler.toPerson
import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.PersonId.personId
import static org.celllife.idart.domain.identifiable.IdentifiableType.PERSON
import static org.celllife.idart.domain.identifiable.Identifier.newIdentifier

/**
 */
@Named class PersonApplicationServiceImpl implements PersonApplicationService {

    @Inject PersonService personService

    @Inject IdentifiableService identifiableService

    @Override
    Person findByPersonId(PersonId personId) {

        if (personId != null) {
            return personService.findByPersonId(personId)
        }

        null
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
}
