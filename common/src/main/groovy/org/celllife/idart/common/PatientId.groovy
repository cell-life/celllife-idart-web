package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Patient Id
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PatientId implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static PatientId valueOf(String string) {
        new PatientId ( value: string )
    }

    @Override
    String toString() {
         value 
    }
}
