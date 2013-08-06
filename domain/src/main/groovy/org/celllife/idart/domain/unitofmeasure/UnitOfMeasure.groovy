package org.celllife.idart.domain.unitofmeasure

import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureType

/**
 */
class UnitOfMeasure {

    static final String NAMESPACE = "http://www.cell-life.org/idart/unitsOfMeasure"

    UnitOfMeasureCode code

    String name

    String description

    UnitOfMeasureType type

}
