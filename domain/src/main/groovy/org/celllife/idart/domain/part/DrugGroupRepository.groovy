package org.celllife.idart.domain.part;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface DrugGroupRepository {

    DrugGroup save(DrugGroup drugGroup)

    public <S extends DrugGroup> Iterable<S> save(Iterable<S> drugGroups)

    DrugGroup findOne(Long pk)

    Iterable<DrugGroup> findAll()

    DrugGroup findOneByIdentifier(String identifierSystem, String identifierValue)

    Iterable<DrugGroup> findByIdentifier(String identifierValue)
}
