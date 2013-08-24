package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Entry Site Code
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class EntrySiteCode implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static EntrySiteCode valueOf(String string) {
        new EntrySiteCode ( value: string )
    }

    @Override
    String toString() {
         value 
    }
}
