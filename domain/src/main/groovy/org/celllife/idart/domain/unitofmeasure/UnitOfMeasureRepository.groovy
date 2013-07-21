package org.celllife.idart.domain.unitofmeasure;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 20h35
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface UnitOfMeasureRepository {

    // UnitOfMeasure save(UnitOfMeasure unitOfMeasure);

    // Iterable<UnitOfMeasure> save(Iterable<UnitOfMeasure> unitsOfMeasure);

    // UnitOfMeasure findOne(Long pk);

    // Iterable<UnitOfMeasure> findAll();

    UnitOfMeasure findOneByCode(String system, String code);

}
