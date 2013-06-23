package org.celllife.idart.domain.concept;

import com.google.common.base.Objects;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 14h51
 */
@Embeddable
public final class Code implements Serializable {

    @NotNull
    private String system;

    @NotNull
    private String value;

    public Code() {
    }

    public Code(String system, String value) {
        this.system = system;
        this.value = value;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String code) {
        this.value = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Code code1 = (Code) o;

        if (!value.equals(code1.value)) return false;
        if (!system.equals(code1.system)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = system.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("system", system)
                .add("code", value)
                .toString();
    }
}
