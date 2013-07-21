package org.celllife.idart.application.practitioner;

import org.celllife.idart.domain.common.Identifier;
import org.celllife.idart.domain.practitioner.Practitioner;

import java.util.Set;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 01h42
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PractitionerResourceService {

    Practitioner save(Practitioner practitioner);

    Practitioner findByIdentifier(String identifier);

    Iterable<Practitioner> findAll();

}