package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Indication Code
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class IndicationCode implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static IndicationCode valueOf(String string) {
        new IndicationCode ( value: string )
    }

    @Override
    String toString() {
         value 
    }
}