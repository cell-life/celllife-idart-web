package org.celllife.idart.application.person

import org.celllife.idart.application.person.dto.PersonDto
import org.celllife.idart.common.PersonId
import org.celllife.idart.domain.identifiable.Identifier
import org.celllife.idart.domain.person.Person

/**
 */
interface PersonApplicationService {

    Boolean exists(PersonId personId)

    PersonId save(PersonDto person)

    PersonDto findByIdentifier(Identifier identifier)

    PersonDto findByPersonId(PersonId personId)
}
