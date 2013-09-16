package org.celllife.idart.domain.unitofmeasure

import org.celllife.idart.common.UnitOfMeasureCode
import org.celllife.idart.common.UnitOfMeasureTypeCode

/**
 * Unit Of Measure 
 *
 */
class UnitOfMeasure implements Serializable {

    /**
     * Unit Of Measure Code 
     */
    UnitOfMeasureCode code

    /**
     * Name 
     */
    String name

    /**
     * Description 
     */
    String description

    /**
     * Has Type
     */
    UnitOfMeasureTypeCode type

}
