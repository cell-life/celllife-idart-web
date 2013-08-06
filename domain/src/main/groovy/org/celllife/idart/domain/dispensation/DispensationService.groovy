package org.celllife.idart.domain.dispensation

import org.celllife.idart.domain.common.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface DispensationService {

    Dispensation save(Dispensation dispensation)

    Iterable<Dispensation> findAll()

    Dispensation findByIdentifier(String identifier)

    Dispensation findByIdentifiers(Iterable<Identifier> identifiers)

}