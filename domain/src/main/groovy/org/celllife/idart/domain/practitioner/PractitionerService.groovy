package org.celllife.idart.domain.practitioner

import org.celllife.idart.domain.common.Identifier

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface PractitionerService {

    Practitioner save(Practitioner practitioner)

    Iterable<Practitioner> findAll()

    Practitioner findByIdentifier(String identifier)

    Practitioner findByIdentifiers(Iterable<Identifier> identifiers)

}