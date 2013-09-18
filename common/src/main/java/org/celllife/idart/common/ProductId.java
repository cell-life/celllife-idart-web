package org.celllife.idart.common;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

/**
 * Product Id
 *
 */
public class ProductId implements Serializable {

    /**
     * Value
     */
    private String value;

    public ProductId() {
    }

    public static ProductId valueOf(String string) {
        return productId(string);
    }

    public static ProductId productId(String value) {

        ProductId productId = new ProductId();
        productId.value = value;

        return productId;
    }

    @JsonValue
    public String getValue() {
         return this.value;
    }

    public void setValue(String value) {
         this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductId that = (ProductId) o;

        if (!value.equals(that.value)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return getValue();
    }
}
