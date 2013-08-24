package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Facility Id
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class FacilityId implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static FacilityId valueOf(String string) {
        new FacilityId ( value: string )
    }

    @Override
    String toString() {
         value 
    }
}
