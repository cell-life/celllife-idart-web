package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Life Event Code
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class LifeEventCode implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static LifeEventCode valueOf(String string) {
        new LifeEventCode ( value: string )
    }

    @Override
    String toString() {
         value 
    }
}
