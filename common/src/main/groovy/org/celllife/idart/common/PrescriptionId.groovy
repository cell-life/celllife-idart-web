package org.celllife.idart.common

import com.fasterxml.jackson.annotation.JsonValue
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
        prescriptionId(string)
    }

    static PrescriptionId prescriptionId(String string) {
        new PrescriptionId ( value: string )
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
