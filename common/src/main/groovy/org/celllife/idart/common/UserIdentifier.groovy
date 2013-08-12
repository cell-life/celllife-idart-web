package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * User Identifier
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class UserIdentifier implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static UserIdentifier valueOf(String string) {
        new UserIdentifier ( value: string )
    }

    @Override
    String toString() {
         value 
    }
}