package org.celllife.idart.domain.practitioner

import org.celllife.idart.common.PersonId
import org.celllife.idart.common.PractitionerId

import javax.annotation.Generated

/**
 */
public interface PractitionerRepository {

    boolean exists(PractitionerId practitionerId)

    Practitioner save(Practitioner practitioner)

    Practitioner findOne(PractitionerId practitionerId)

    PersonId findPersonByPractitionerId(PractitionerId practitionerId)
}
