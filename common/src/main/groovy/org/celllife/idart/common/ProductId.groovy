package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Product Id
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class ProductId implements Serializable {

    /**
     * Value
     */
    String value

    static ProductId valueOf(String string) {
        new ProductId(value: string)
    }

    @Override
    String toString() {
        value
    }
}
