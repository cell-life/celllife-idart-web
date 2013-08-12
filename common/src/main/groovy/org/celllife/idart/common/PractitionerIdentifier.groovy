package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Practitioner Identifier
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PractitionerIdentifier implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static PractitionerIdentifier valueOf(String string) {
        new PractitionerIdentifier ( value: string )
    }

    @Override
    String toString() {
         value 
    }
}