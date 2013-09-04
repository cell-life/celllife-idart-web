package org.celllife.idart.common

import com.fasterxml.jackson.annotation.JsonValue
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
        unitOfMeasureCode(string)
    }

    static UnitOfMeasureCode unitOfMeasureCode(String string) {
        new UnitOfMeasureCode ( value: string )
    }
    
    @JsonValue
    String getValue() {
         this.value
    }

    def setValue(String value) {
         this.value = value
    }
    
    @Override
    String toString() {
         value 
    }
}
