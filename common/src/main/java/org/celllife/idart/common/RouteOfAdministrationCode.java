package org.celllife.idart.common;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

/**
 * Route Of Administration Code
 *
 */
public class RouteOfAdministrationCode implements Serializable {

    private static final long serialVersionUID = -7775565262635332797L;

    /**
     * Value
     */
    private String value;

    public RouteOfAdministrationCode() {
    }

    public static RouteOfAdministrationCode valueOf(String string) {
        return routeOfAdministrationCode(string);
    }

    public static RouteOfAdministrationCode routeOfAdministrationCode(String value) {

        RouteOfAdministrationCode routeOfAdministrationCode = new RouteOfAdministrationCode();
        routeOfAdministrationCode.value = value;

        return routeOfAdministrationCode;
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

        RouteOfAdministrationCode that = (RouteOfAdministrationCode) o;

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
