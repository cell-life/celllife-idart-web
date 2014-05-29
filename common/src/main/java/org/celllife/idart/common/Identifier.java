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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((system == null) ? 0 : system.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Identifier other = (Identifier) obj;
        if (system == null) {
            if (other.system != null)
                return false;
        } else if (!system.equals(other.system))
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Identifier [system=" + system + ", value=" + value + "]";
    }
}