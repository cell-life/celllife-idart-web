package org.celllife.idart.common

import com.fasterxml.jackson.annotation.JsonValue
import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Person Id
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PersonId implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static PersonId valueOf(String string) {
        new PersonId ( value: string )
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
