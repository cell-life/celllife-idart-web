package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Drug Identifier
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class DrugIdentifier implements Serializable {

    /**
     * Value
     */
    String value

    static DrugIdentifier valueOf(String string) {
        new DrugIdentifier(value: string)
    }

    @Override
    String toString() {
        value
    }
}