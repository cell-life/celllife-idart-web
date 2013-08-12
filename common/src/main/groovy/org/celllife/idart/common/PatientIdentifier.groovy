package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Patient Identifier
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PatientIdentifier implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static PatientIdentifier valueOf(String string) {
        new PatientIdentifier ( value: string )
    }

    @Override
    String toString() {
         value 
    }
}