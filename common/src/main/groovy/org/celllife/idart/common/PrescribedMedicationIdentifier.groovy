package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * PrescribedMedication Identifier
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PrescribedMedicationIdentifier implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static PrescribedMedicationIdentifier valueOf(String string) {
        new PrescribedMedicationIdentifier ( value: string )
    }

    @Override
    String toString() {
         value 
    }
}