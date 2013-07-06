package org.celllife.idart.domain.common;

import org.celllife.idart.domain.concept.Code;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-23
 * Time: 14h17
 */
privileged aspect CodeableAspect {

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Code> Codeable.codes = new HashSet<>();

    public Set<Code> Codeable.getCodes() {
        return codes;
    }

    public void Codeable.setCodes(Set<Code> codes) {
        this.codes = codes;
    }

    public void Codeable.addCode(String system, String code) {
        if (this.codes == null) {
            this.codes = new HashSet<>();
        }

        this.codes.add(new Code(system, code));
    }

    public String Codeable.getFirstSystem() {
        if (this.codes == null || this.codes.isEmpty()) {
            return null;
        }

        return this.codes.iterator().next().getSystem();
    }

    public String Codeable.getCodeValue(String system) {

        if (system == null) {
            return null;
        }

        for (Code code : codes) {
            if (code.getSystem().equals(system)) {
                return code.getValue();
            }
        }

        return null;
    }

    public Set<String> Codeable.getCodeSystems() {

        Set<String> systems = new HashSet<>();
        for (Code code : codes) {
            systems.add(code.getSystem());
        }

        return systems;
    }

    public void Codeable.mergeCodes(Codeable that) {

        if (!this.getClass().isAssignableFrom(that.getClass())) {
            throw new RuntimeException(
                    String.format(
                            "Incompatible CodedConcept Types: this[%s] that[%s]",
                            this.getClass(),
                            that.getClass()
                    )
            );
        }

        for (String system : that.getCodeSystems()) {
            this.addCode(system, that.getCodeValue(system));
        }
    }
}
