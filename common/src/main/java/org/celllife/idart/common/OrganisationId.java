package org.celllife.idart.common;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

/**
 * Organisation Id
 *
 */
public class OrganisationId implements Serializable {

    private static final long serialVersionUID = -5146072357941965219L;

    /**
     * Value
     */
    private String value;

    public OrganisationId() {
    }

    public static OrganisationId valueOf(String string) {
        return organisationId(string);
    }

    public static OrganisationId organisationId(String value) {

        OrganisationId organisationId = new OrganisationId();
        organisationId.value = value;

        return organisationId;
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

        OrganisationId that = (OrganisationId) o;

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
