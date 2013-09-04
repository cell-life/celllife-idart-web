package org.celllife.idart.common

import com.fasterxml.jackson.annotation.JsonValue
import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Administration Method Code
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class AdministrationMethodCode implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static AdministrationMethodCode valueOf(String string) {
        administrationMethodCode(string)
    }

    static AdministrationMethodCode administrationMethodCode(String string) {
        new AdministrationMethodCode ( value: string )
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
