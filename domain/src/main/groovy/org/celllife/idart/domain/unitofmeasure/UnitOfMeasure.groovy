package org.celllife.idart.domain.unitofmeasure

import org.celllife.idart.common.UnitOfMeasureCode
import org.celllife.idart.common.UnitOfMeasureTypeCode

import javax.annotation.Generated

/**
 * Unit Of Measure 
 *
 */
class UnitOfMeasure {

    /**
     * Namespace
     */
    static NAMESPACE = "http://www.cell-life.org/idart/unitsOfMeasure"

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