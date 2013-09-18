package org.celllife.idart.common;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

/**
 * Person Id
 *
 */
public class PersonId implements Serializable {

    /**
     * Value
     */
    private String value;

    public PersonId() {
    }

    public static PersonId valueOf(String string) {
        return personId(string);
    }

    public static PersonId personId(String value) {

        PersonId personId = new PersonId();
        personId.value = value;

        return personId;
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

        PersonId that = (PersonId) o;

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
