package org.celllife.idart.domain.drug;

import javax.annotation.Generated;

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface DrugRepository {

    Drug save(Drug drug)

    public <S extends Drug> Iterable<S> save(Iterable<S> drugs)

    Drug findOne(Long pk)

    Iterable<Drug> findAll()

    Drug findOneByIdentifier(String identifierSystem, String identifierValue)

    Iterable<Drug> findByIdentifier(String identifierValue)
}
