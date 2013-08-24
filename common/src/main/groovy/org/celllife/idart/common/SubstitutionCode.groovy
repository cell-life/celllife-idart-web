package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Substitution Code
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class SubstitutionCode implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static SubstitutionCode valueOf(String string) {
        new SubstitutionCode ( value: string )
    }

    @Override
    String toString() {
         value 
    }
}
