package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Prescription Identifier
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PrescriptionIdentifier implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static PrescriptionIdentifier valueOf(String string) {
        new PrescriptionIdentifier ( value: string )
    }

    @Override
    String toString() {
         value 
    }
}