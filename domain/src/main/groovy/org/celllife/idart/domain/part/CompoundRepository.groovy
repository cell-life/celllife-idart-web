package org.celllife.idart.domain.part;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface CompoundRepository {

    Compound save(Compound compound)

    public <S extends Compound> Iterable<S> save(Iterable<S> compounds)

    Compound findOne(Long pk)

    Iterable<Compound> findAll()

    Compound findOneByIdentifier(String identifierSystem, String identifierValue)

    Iterable<Compound> findByIdentifier(String identifierValue)
}
