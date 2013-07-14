package org.celllife.idart.domain.unitofmeasure

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-21
 * Time: 20h01
 */
interface UnitOfMeasureService {

    def save(Iterable<UnitOfMeasure> unitOfMeasures)

    def save(UnitOfMeasure unitOfMeasure)

}
