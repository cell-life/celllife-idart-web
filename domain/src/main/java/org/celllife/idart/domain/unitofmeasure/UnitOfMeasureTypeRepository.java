package org.celllife.idart.domain.unitofmeasure;


/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 17h50
 */
public interface UnitOfMeasureTypeRepository {

    UnitOfMeasureType findOneByName(String locale, String value);
}
