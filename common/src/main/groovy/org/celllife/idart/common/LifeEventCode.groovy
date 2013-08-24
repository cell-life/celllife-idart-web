package org.celllife.idart.common

import com.fasterxml.jackson.annotation.JsonValue
import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Life Event Code
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class LifeEventCode implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static LifeEventCode valueOf(String string) {
        new LifeEventCode ( value: string )
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
