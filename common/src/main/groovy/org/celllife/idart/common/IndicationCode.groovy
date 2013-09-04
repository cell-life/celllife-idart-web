package org.celllife.idart.common

import com.fasterxml.jackson.annotation.JsonValue
import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Indication Code
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class IndicationCode implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static IndicationCode valueOf(String string) {
        indicationCode(string)
    }

    static IndicationCode indicationCode(String string) {
        new IndicationCode ( value: string )
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
