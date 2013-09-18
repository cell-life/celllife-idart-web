package org.celllife.idart.common;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

/**
 * User Id
 *
 */
public class UserId implements Serializable {

    /**
     * Value
     */
    private String value;

    public UserId() {
    }

    public static UserId valueOf(String string) {
        return userId(string);
    }

    public static UserId userId(String value) {

        UserId userId = new UserId();
        userId.value = value;

        return userId;
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

        UserId that = (UserId) o;

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
