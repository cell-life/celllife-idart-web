package org.celllife.idart.common

import com.fasterxml.jackson.annotation.JsonValue
import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Default Dosage Instruction Id
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class DefaultDosageInstructionId implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static DefaultDosageInstructionId valueOf(String string) {
        new DefaultDosageInstructionId ( value: string )
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
