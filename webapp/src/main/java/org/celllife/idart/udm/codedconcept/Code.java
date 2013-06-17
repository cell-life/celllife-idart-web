package org.celllife.idart.udm.codedconcept;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 14h51
 */
@Embeddable
public final class Code implements Serializable {

    private String system;

    private String code;

    public Code() {
    }

    public Code(String system, String code) {
        this.system = system;
        this.code = code;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
