package org.celllife.idart.domain.unitofmeasure;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface UnitOfMeasureRepository {

    UnitOfMeasure save(UnitOfMeasure unitOfMeasure)

    public <S extends UnitOfMeasure> Iterable<S> save(Iterable<S> unitsOfMeasure)

    UnitOfMeasure findOne(Long pk)

    Iterable<UnitOfMeasure> findAll()

    UnitOfMeasure findOneByCode(String system, String code);

}
