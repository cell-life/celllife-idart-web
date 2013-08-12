package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * DispensedMedication Identifier
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class DispensedMedicationIdentifier implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static DispensedMedicationIdentifier valueOf(String string) {
        new DispensedMedicationIdentifier ( value: string )
    }

    @Override
    String toString() {
         value 
    }
}