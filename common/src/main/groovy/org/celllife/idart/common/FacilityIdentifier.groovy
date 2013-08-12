package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Facility Identifier
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class FacilityIdentifier implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static FacilityIdentifier valueOf(String string) {
        new FacilityIdentifier ( value: string )
    }

    @Override
    String toString() {
         value 
    }
}