package org.celllife.idart.common;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import javax.annotation.Generated;

/**
 * Route Of Administration Code
 *
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
public class RouteOfAdministrationCode implements Serializable {

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
