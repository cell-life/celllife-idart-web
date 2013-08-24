package org.celllife.idart.common

import com.fasterxml.jackson.annotation.JsonValue
import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Route Of Administration Code
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class RouteOfAdministrationCode implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static RouteOfAdministrationCode valueOf(String string) {
        new RouteOfAdministrationCode ( value: string )
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
