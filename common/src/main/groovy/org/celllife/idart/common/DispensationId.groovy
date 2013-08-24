package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Dispensation Id
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class DispensationId implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static DispensationId valueOf(String string) {
        new DispensationId ( value: string )
    }

    @Override
    String toString() {
         value 
    }
}
