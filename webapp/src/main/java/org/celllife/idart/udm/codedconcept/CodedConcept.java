package org.celllife.idart.udm.codedconcept;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.celllife.idart.udm.common.BaseEntity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-17
 * Time: 14h25
 */
@Entity
@DiscriminatorColumn(name = "type")
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public abstract class CodedConcept extends BaseEntity {

    @ElementCollection
    private Set<Code> codes;

    @NotNull
    private String name;

    private String description;

    @ManyToOne
    private CodedConcept parent;

    public CodedConcept() {
    }

    public Set<Code> getCodes() {
        return codes;
    }

    public void setCodes(Set<Code> codes) {
        this.codes = codes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CodedConcept getParent() {
        return parent;
    }

    public void setParent(CodedConcept parent) {
        this.parent = parent;
    }

    public void addCode(String system, String code) {
        if (this.codes == null) {
            this.codes = new HashSet<>();
        }

        this.codes.add(new Code(system, code));
    }
}
