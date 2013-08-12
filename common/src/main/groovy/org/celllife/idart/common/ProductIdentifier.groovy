package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated

/**
 * Product Identifier
 *
 */
@EqualsAndHashCode
@Generated("org.celllife.idart.codegen.CodeGenerator")
class ProductIdentifier implements Serializable {

    /**
     * Value
     */
    String value

    static ProductIdentifier valueOf(String string) {
        new ProductIdentifier(value: string)
    }

    @Override
    String toString() {
        value
    }
}