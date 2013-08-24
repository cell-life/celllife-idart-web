package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Drug Id
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class DrugId implements Serializable {

    /**
     * Value
     */
    String value

    static DrugId valueOf(String string) {
        new DrugId(value: string)
    }

    @Override
    String toString() {
        value
    }
}
