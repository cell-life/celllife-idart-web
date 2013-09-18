package org.celllife.idart.common;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import javax.annotation.Generated;

/**
 * System Id
 *
 */
public class SystemId implements Serializable {

    public static final SystemId IDART_WEB = valueOf("IDART_WEB");

    public static final SystemId PREHMIS = valueOf("PREHMIS");

    public static final SystemId PGWC = valueOf("PGWC");

    public static final SystemId SA_IDENTITY_NUMBER = valueOf("SA_IDENTITY_NUMBER");

    public static final SystemId SA_PASSPART_NUMBER = valueOf("SA_PASSPART_NUMBER");

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
