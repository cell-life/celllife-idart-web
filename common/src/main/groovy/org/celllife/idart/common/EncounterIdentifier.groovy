package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Encounter Identifier
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class EncounterIdentifier implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static EncounterIdentifier valueOf(String string) {
        new EncounterIdentifier ( value: string )
    }

    @Override
    String toString() {
         value 
    }
}