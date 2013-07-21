package org.celllife.idart.domain.part;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface SubassemblyRepository {

    Subassembly save(Subassembly subassembly)

    public <S extends Subassembly> Iterable<S> save(Iterable<S> subassemblys)

    Subassembly findOne(Long pk)

    Iterable<Subassembly> findAll()

    Subassembly findOneByIdentifier(String identifierSystem, String identifierValue)

    Iterable<Subassembly> findByIdentifier(String identifierValue)
}
