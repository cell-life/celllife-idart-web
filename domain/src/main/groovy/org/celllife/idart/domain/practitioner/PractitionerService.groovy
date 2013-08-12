package org.celllife.idart.domain.practitioner

import org.celllife.idart.common.PractitionerIdentifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PractitionerService {

    Practitioner save(Practitioner practitioner) throws PractitionerValidationException

    Practitioner findByPractitionerIdentifier(PractitionerIdentifier practitionerIdentifier) throws PractitionerNotFoundException

}