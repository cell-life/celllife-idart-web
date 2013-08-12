package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Dispensation Identifier
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class DispensationIdentifier implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static DispensationIdentifier valueOf(String string) {
        new DispensationIdentifier ( value: string )
    }

    @Override
    String toString() {
         value 
    }
}