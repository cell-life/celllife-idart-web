package org.celllife.idart.domain.common;

import org.celllife.idart.domain.concept.Code;
import org.celllife.idart.domain.concept.Codes;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-23
 * Time: 14h17
 */
privileged aspect CodeableAspect {

    @OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    private Codes Codeable.codes = new Codes();

    public Set<String> Codeable.getCodeSystems() {
        return this.codes.getCodeSystems();
    }

    public String Codeable.getCodeValue(String system) {
        return this.codes.getCodeValue(system);
    }

    public String Codeable.getFirstSystem() {
        return this.codes.getFirstSystem();
    }

    public void Codeable.addCode(String system, String code) {
        this.codes.addCode(system, code);
    }

    public void Codeable.setCodes(Set<Code> codes) {
        this.codes.setCodes(codes);
    }

    public Set<Code> Codeable.getCodes() {
        return this.codes.getCodes();
    }

    public void Codeable.mergeCodes(Codeable that) {
        this.codes.mergeCodes(that.codes);
    }

}
