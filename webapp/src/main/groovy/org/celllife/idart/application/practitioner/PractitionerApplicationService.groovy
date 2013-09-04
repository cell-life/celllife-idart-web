package org.celllife.idart.application.practitioner

import org.celllife.idart.common.PractitionerId
import org.celllife.idart.domain.practitioner.Practitioner

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface PractitionerApplicationService {

    Practitioner save(Practitioner practitioner)

    Practitioner findByPractitionerId(PractitionerId practitionerId)

}
