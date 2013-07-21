package org.celllife.idart.domain.product;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface GoodRepository {

    Good save(Good good)

    public <S extends Good> Iterable<S> save(Iterable<S> goods)

    Good findOne(Long pk)

    Iterable<Good> findAll()

    Good findOneByIdentifier(String identifierSystem, String identifierValue)

    Iterable<Good> findByIdentifier(String identifierValue)
}
