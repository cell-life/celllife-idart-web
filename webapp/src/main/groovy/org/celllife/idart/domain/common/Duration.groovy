package org.celllife.idart.domain.common

import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure

import static org.celllife.idart.framework.aspectj.InjectCoded.inject

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 11h17
 */
class Duration {

    BigDecimal value

    UnitOfMeasure unitOfMeasure

    void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = inject(unitOfMeasure)
    }
}
