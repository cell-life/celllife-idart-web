package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Compound Identifier
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class CompoundIdentifier implements Serializable {

    /**
     * Value
     */
    String value

    static CompoundIdentifier valueOf(String string) {
        new CompoundIdentifier(value: string)
    }

    @Override
    String toString() {
        value
    }
}