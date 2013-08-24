package org.celllife.idart.common

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

    @Override
    String toString() {
         value 
    }
}
