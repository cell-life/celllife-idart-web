package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Prescription Id
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PrescriptionId implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static PrescriptionId valueOf(String string) {
        new PrescriptionId ( value: string )
    }

    @Override
    String toString() {
         value 
    }
}
