package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Person Id
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PersonId implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static PersonId valueOf(String string) {
        new PersonId ( value: string )
    }

    @Override
    String toString() {
         value 
    }
}
