package org.celllife.idart.application.person

import org.celllife.idart.domain.person.Person
import org.celllife.idart.domain.person.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-15
 * Time: 23h08
 */
@Service class PersonApplicationServiceImpl implements PersonApplicationService {

    @Autowired PersonService personService

    Person save(Person person) {
        personService.save(person)
    }

    @Override
    Person update(Person person, Long existingPersonPk){
        personService.update(person, existingPersonPk)
    }
}
