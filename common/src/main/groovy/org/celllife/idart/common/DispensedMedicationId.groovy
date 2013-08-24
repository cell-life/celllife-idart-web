package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * DispensedMedication Id
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class DispensedMedicationId implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static DispensedMedicationId valueOf(String string) {
        new DispensedMedicationId ( value: string )
    }

    @Override
    String toString() {
         value 
    }
}
