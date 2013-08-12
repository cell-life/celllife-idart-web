package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Default Dosage Instruction Identifier
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class DefaultDosageInstructionIdentifier implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static DefaultDosageInstructionIdentifier valueOf(String string) {
        new DefaultDosageInstructionIdentifier ( value: string )
    }

    @Override
    String toString() {
         value 
    }
}