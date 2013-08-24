package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * System Id
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class SystemId implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static SystemId valueOf(String string) {
        new SystemId ( value: string )
    }

    @Override
    String toString() {
         value 
    }
}
