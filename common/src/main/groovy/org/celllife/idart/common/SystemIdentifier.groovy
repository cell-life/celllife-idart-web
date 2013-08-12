package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * System Identifier
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class SystemIdentifier implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static SystemIdentifier valueOf(String string) {
        new SystemIdentifier ( value: string )
    }

    @Override
    String toString() {
         value 
    }
}