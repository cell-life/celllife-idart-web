package org.celllife.idart.common;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-24
 * Time: 16h52
 */
public class Label implements Serializable {

    private static final long serialVersionUID = 5654482526916119469L;

    private String value;

    public Label() {
    }

    public static Label valueOf(String value) {
        return label(value);
    }

    public static Label label(String value) {

        Label label = new Label();
        label.value = value;

        return label;
    }

    @JsonValue
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

        Label label = (Label) o;

        if (value != null ? !value.equals(label.value) : label.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return getValue();
    }
}
