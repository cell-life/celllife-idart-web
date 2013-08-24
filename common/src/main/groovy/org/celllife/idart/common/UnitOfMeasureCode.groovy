package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Unit Of Measure Code
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class UnitOfMeasureCode implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static UnitOfMeasureCode valueOf(String string) {
        new UnitOfMeasureCode ( value: string )
    }

    @Override
    String toString() {
         value 
    }
}
