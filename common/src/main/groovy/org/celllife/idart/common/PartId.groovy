package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Part Id
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class PartId implements Serializable {

    /**
     * Value
     */
    String value

    static PartId valueOf(String string) {
        new PartId(value: string)
    }

    @Override
    String toString() {
        value
    }
}
