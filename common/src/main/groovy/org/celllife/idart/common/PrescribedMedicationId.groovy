package org.celllife.idart.common

import com.fasterxml.jackson.annotation.JsonValue
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
