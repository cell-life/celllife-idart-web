package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 11h17
 */
@EqualsAndHashCode
class Quantity {

    BigDecimal value

    UnitOfMeasureCode unitOfMeasure

    static Quantity newQuantity(BigDecimal value, UnitOfMeasureCode unitOfMeasure) {
        new Quantity(value: value, unitOfMeasure: unitOfMeasure)
    }
}
