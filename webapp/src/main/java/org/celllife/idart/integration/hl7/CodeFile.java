package org.celllife.idart.integration.hl7;

import java.util.HashSet;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-21
 * Time: 18h36
 */
public class CodeFile {

    private String name;

    private String system;

    private Set<Code> codes = new HashSet<>();

    public CodeFile() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public Set<Code> getCodes() {
        return codes;
    }

    public void setCodes(Set<Code> codes) {
        this.codes = codes;
    }
}
