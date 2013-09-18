package org.celllife.idart.application.person

import org.celllife.idart.application.person.dto.PersonDto
import org.celllife.idart.common.PersonId
import org.celllife.idart.common.Identifier


/**
 */
interface PersonApplicationService {

    Boolean exists(PersonId personId)

    PersonId save(PersonDto personDto)

    PersonDto findByPersonId(PersonId personId)

    PersonDto findByIdentifier(Identifier identifier)

    PersonId findByIdentifiers(Set<Identifier> identifiers)

}
