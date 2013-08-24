package org.celllife.idart.domain.practitioner

import org.celllife.idart.common.PractitionerId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PractitionerService {

    Practitioner save(Practitioner practitioner) throws PractitionerValidationException

    Practitioner findByPractitionerId(PractitionerId practitionerId) throws PractitionerNotFoundException

}
