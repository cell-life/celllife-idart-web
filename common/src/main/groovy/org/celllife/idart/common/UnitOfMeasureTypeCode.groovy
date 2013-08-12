package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Unit Of Measure Type Code
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class UnitOfMeasureTypeCode implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static UnitOfMeasureTypeCode valueOf(String string) {
        new UnitOfMeasureTypeCode ( value: string )
    }

    @Override
    String toString() {
         value 
    }
}