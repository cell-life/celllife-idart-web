package org.celllife.idart.domain.practitioner

import org.celllife.idart.common.PractitionerId

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PractitionerRepository {

    boolean exists(PractitionerId practitionerId)

    Practitioner save(Practitioner practitioner)

    Practitioner findOne(PractitionerId practitionerId)

}
