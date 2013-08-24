package org.celllife.idart.application.person

import org.celllife.idart.domain.person.Person
import org.celllife.idart.domain.person.PersonValidationException
import org.celllife.idart.domain.person.PersonNotFoundException
import org.celllife.idart.common.PersonId
import org.celllife.idart.domain.person.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class PersonApplicationServiceImpl implements PersonApplicationService {

    @Autowired PersonService personService

    Person save(Person person) throws PersonValidationException {
        personService.save(person)
    }

    Person findByPersonId(PersonId personId) throws PersonNotFoundException{
        personService.findByPersonId(personId)
    }

}
