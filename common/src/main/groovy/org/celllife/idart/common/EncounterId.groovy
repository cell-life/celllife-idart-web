package org.celllife.idart.common

import com.fasterxml.jackson.annotation.JsonValue
import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Encounter Id
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class EncounterId implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static EncounterId valueOf(String string) {
        encounterId(string)
    }

    static EncounterId encounterId(String string) {
        new EncounterId ( value: string )
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
