package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * User Id
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class UserId implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static UserId valueOf(String string) {
        new UserId ( value: string )
    }

    @Override
    String toString() {
         value 
    }
}
