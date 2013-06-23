package org.celllife.idart.domain.concept;

import org.celllife.idart.udm.common.BaseEntity;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 14h25
 */
@Entity
public final class Codes extends BaseEntity {

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Code> codes;

    public Codes() {
    }

    public Set<Code> getCodes() {
        return codes;
    }

    public void setCodes(Set<Code> codes) {
        this.codes = codes;
    }

    public void addCode(String system, String code) {
        if (this.codes == null) {
            this.codes = new HashSet<>();
        }

        this.codes.add(new Code(system, code));
    }

    public String getFirstSystem() {
        if (this.codes == null || this.codes.isEmpty()) {
            return null;
        }

        return this.codes.iterator().next().getSystem();
    }

    public String getCodeValue(String system) {

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

    public Set<String> getCodeSystems() {

        Set<String> systems = new HashSet<>();
        for (Code code : codes) {
            systems.add(code.getSystem());
        }

        return systems;
    }

    public void mergeCodes(Codes that) {

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
