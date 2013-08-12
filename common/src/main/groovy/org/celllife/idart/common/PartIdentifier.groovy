package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Part Identifier
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PartIdentifier implements Serializable {

    /**
     * Value
     */
    String value

    static PartIdentifier valueOf(String string) {
        new PartIdentifier(value: string)
    }

    @Override
    String toString() {
        value
    }
}