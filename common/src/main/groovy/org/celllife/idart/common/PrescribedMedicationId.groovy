package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * PrescribedMedication Id
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PrescribedMedicationId implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static PrescribedMedicationId valueOf(String string) {
        new PrescribedMedicationId ( value: string )
    }

    @Override
    String toString() {
         value 
    }
}
