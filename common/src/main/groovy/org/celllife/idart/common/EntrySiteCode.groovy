package org.celllife.idart.common

import com.fasterxml.jackson.annotation.JsonValue
import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Entry Site Code
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class EntrySiteCode implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static EntrySiteCode valueOf(String string) {
        entrySiteCode(string)
    }

    static EntrySiteCode entrySiteCode(String string) {
        new EntrySiteCode ( value: string )
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
