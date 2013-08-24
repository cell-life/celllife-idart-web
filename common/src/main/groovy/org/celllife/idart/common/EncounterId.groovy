package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Encounter Id
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class EncounterId implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static EncounterId valueOf(String string) {
        new EncounterId ( value: string )
    }

    @Override
    String toString() {
         value 
    }
}
