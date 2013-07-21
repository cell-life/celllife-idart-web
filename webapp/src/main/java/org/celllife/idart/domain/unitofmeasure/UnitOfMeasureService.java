package org.celllife.idart.domain.unitofmeasure;

import javax.annotation.Generated;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 02h48
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public interface UnitOfMeasureService {

    Iterable<UnitOfMeasure> save(Iterable<UnitOfMeasure> unitsOfMeasure);

    UnitOfMeasure save(UnitOfMeasure unitOfMeasure);

    Iterable<UnitOfMeasure> findAll();

    UnitOfMeasure findByIdentifier(String identifier);

}