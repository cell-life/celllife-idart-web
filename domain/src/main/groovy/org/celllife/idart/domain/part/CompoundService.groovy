package org.celllife.idart.domain.part

import org.celllife.idart.domain.common.Identifier

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface CompoundService {

    Compound save(Compound compound)

    Iterable<Compound> findAll()

    Compound findByIdentifier(String identifier)

    Compound findByIdentifiers(Iterable<Identifier> identifiers)

}