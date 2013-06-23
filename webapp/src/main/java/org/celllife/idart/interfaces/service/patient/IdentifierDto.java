package org.celllife.idart.interfaces.service.patient;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-23
 * Time: 11h00
 */
public final class IdentifierDto implements Serializable {

    private String system;

    @NotNull
    private String value;

    public IdentifierDto() {
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

    public void setValue(String value) {
        this.value = value;
    }
}
