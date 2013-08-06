package org.celllife.idart.domain.compound

import org.celllife.idart.domain.common.Identifier

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface CompoundService {

    Compound save(Compound compound)

    Iterable<Compound> findAll()

    Compound findByIdentifier(String identifier)

    Compound findByIdentifiers(Iterable<Identifier> identifiers)

}