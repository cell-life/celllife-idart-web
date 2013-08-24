package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Compound Id
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class CompoundId implements Serializable {

    /**
     * Value
     */
    String value

    static CompoundId valueOf(String string) {
        new CompoundId(value: string)
    }

    @Override
    String toString() {
        value
    }
}
