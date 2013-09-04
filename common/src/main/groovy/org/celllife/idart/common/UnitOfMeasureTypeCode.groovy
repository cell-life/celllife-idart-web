package org.celllife.idart.common

import com.fasterxml.jackson.annotation.JsonValue
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
        unitOfMeasureTypeCode(string)
    }

    static UnitOfMeasureTypeCode unitOfMeasureTypeCode(String string) {
        new UnitOfMeasureTypeCode ( value: string )
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
