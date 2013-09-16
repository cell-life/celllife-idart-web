package org.celllife.idart.domain.practitioner

import org.celllife.idart.common.PersonId
import org.celllife.idart.common.PractitionerId

/**
 */
public interface PractitionerService {

    Boolean exists(PractitionerId practitionerId)

    Practitioner save(Practitioner practitioner)

    Practitioner findByPractitionerId(PractitionerId practitionerId)

    PersonId findPersonByPractitionerId(PractitionerId practitionerId)

}
