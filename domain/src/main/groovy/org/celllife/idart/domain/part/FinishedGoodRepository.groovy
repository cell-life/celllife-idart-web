package org.celllife.idart.domain.part;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface FinishedGoodRepository {

    FinishedGood save(FinishedGood finishedGood)

    public <S extends FinishedGood> Iterable<S> save(Iterable<S> finishedGoods)

    FinishedGood findOne(Long pk)

    Iterable<FinishedGood> findAll()

    FinishedGood findOneByIdentifier(String identifierSystem, String identifierValue)

    Iterable<FinishedGood> findByIdentifier(String identifierValue)
}
