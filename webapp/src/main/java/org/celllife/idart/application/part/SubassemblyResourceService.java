package org.celllife.idart.application.part;

import org.celllife.idart.domain.part.Subassembly;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h33
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SubassemblyResourceService {

    Subassembly save(Subassembly subassembly);

    Subassembly findByIdentifier(String identifier);

    Iterable<Subassembly> findAll();

}