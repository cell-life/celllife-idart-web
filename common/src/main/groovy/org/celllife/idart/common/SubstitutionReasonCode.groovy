package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Substitution Reason Code
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class SubstitutionReasonCode implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static SubstitutionReasonCode valueOf(String string) {
        new SubstitutionReasonCode ( value: string )
    }

    @Override
    String toString() {
         value 
    }
}