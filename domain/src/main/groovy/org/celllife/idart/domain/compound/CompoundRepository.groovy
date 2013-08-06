package org.celllife.idart.domain.compound;

import javax.annotation.Generated;

/**
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
