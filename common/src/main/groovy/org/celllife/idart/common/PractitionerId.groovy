package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Practitioner Id
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PractitionerId implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static PractitionerId valueOf(String string) {
        new PractitionerId ( value: string )
    }

    @Override
    String toString() {
         value 
    }
}
