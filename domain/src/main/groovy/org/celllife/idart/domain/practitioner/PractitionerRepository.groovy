package org.celllife.idart.domain.practitioner

import org.celllife.idart.common.PractitionerIdentifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PractitionerRepository {

    Practitioner save(Practitioner practitioner)

    Practitioner findOne(PractitionerIdentifier practitionerIdentifier)

}
