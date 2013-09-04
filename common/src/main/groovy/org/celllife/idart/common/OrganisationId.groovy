package org.celllife.idart.common

import com.fasterxml.jackson.annotation.JsonValue
import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Organisation Id
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class OrganisationId implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static OrganisationId valueOf(String string) {
        organisationId(string)
    }

    static OrganisationId organisationId(String string) {
        new OrganisationId ( value: string )
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
