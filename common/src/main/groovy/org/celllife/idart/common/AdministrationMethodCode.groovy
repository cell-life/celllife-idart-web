package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Administration Method Code
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class AdministrationMethodCode implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static AdministrationMethodCode valueOf(String string) {
        new AdministrationMethodCode ( value: string )
    }

    @Override
    String toString() {
         value 
    }
}
