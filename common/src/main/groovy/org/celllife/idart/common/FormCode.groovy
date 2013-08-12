package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Form Code
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class FormCode implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static FormCode valueOf(String string) {
        new FormCode ( value: string )
    }

    @Override
    String toString() {
         value 
    }
}