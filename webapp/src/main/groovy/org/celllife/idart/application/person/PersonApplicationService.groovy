package org.celllife.idart.application.person

import org.celllife.idart.application.person.dto.PersonDto
import org.celllife.idart.common.PersonId
import org.celllife.idart.domain.person.Person

/**
 */
interface PersonApplicationService {

    PersonId save(PersonDto person)

    Person findByPersonId(PersonId personId)

}
