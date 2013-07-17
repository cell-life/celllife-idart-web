package org.celllife.idart.domain.unitofmeasure

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-21
 * Time: 20h01
 */
interface UnitOfMeasureService {

    Iterable<UnitOfMeasure> save(Iterable<UnitOfMeasure> unitOfMeasures)

    UnitOfMeasure save(UnitOfMeasure unitOfMeasure)

}
