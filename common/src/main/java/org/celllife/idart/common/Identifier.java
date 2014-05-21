package org.celllife.idart.common;

import org.celllife.idart.common.SystemId;

import java.io.Serializable;

/**
 * Used to identify a domain entity. An entity can have multiple identifiers for example where there 
 * are multiple systems and each system has its own identifier.
 */
public class Identifier implements Serializable {

    private static final long serialVersionUID = -3242875782209492272L;

    private SystemId system;

    private String value;

    public Identifier() {
    }

    public SystemId getSystem() {
        return system;
    }

    public void setSystem(SystemId system) {
        this.system = system;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Identifier that = (Identifier) o;

        if (system != null ? !system.equals(that.system) : that.system != null) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = system != null ? system.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Identifier [system=" + system + ", value=" + value + "]";
    }

}