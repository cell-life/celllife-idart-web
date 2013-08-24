package org.celllife.idart.application.practitioner

import org.celllife.idart.domain.practitioner.Practitioner
import org.celllife.idart.domain.practitioner.PractitionerValidationException
import org.celllife.idart.domain.practitioner.PractitionerNotFoundException
import org.celllife.idart.common.PractitionerId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
interface PractitionerApplicationService {

    Practitioner save(Practitioner practitioner) throws PractitionerValidationException

    Practitioner findByPractitionerId(PractitionerId practitionerId) throws PractitionerNotFoundException

}
