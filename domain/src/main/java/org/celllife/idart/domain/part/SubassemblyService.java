package org.celllife.idart.domain.part;

import org.celllife.idart.domain.common.Identifier;

import java.util.Set;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 03h45
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SubassemblyService {

    Subassembly save(Subassembly subassembly);

    Iterable<Subassembly> findAll();

    Subassembly findByIdentifier(String identifier);

    Subassembly findByIdentifiers(Set<Identifier> identifiers);


}