package org.celllife.idart.domain.part;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
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
