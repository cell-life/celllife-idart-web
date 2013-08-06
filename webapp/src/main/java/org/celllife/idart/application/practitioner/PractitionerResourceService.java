package org.celllife.idart.application.practitioner;

import org.celllife.idart.domain.practitioner.Practitioner;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PractitionerResourceService {

    Practitioner save(Practitioner practitioner);

    Practitioner findByIdentifier(String identifier);

    Iterable<Practitioner> findAll();

}