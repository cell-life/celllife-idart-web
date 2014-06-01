package org.celllife.idart.common;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

/**
 * System Id
 *
 */
public class SystemId implements Serializable {

    private static final long serialVersionUID = -2155209510605872227L;

    /**
     * Value
     */
    private String value;

    public SystemId() {
    }

    public static SystemId valueOf(String string) {
        return systemId(string);
    }

    public static SystemId systemId(String value) {

        SystemId systemId = new SystemId();
        systemId.value = value;

        return systemId;
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

        SystemId that = (SystemId) o;

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
