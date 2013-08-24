package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Route Of Administration Code
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class RouteOfAdministrationCode implements Serializable {
    
    /**
     * Value
     */
    String value
    
    static RouteOfAdministrationCode valueOf(String string) {
        new RouteOfAdministrationCode ( value: string )
    }

    @Override
    String toString() {
         value 
    }
}
