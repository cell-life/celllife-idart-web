package org.celllife.idart.client.part;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.celllife.idart.common.FormCode;
import org.celllife.idart.common.Identifier;
import org.celllife.idart.common.Label;
import org.celllife.idart.common.UnitOfMeasureCode;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h17
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(name = "DRUG", value = Drug.class),
        @JsonSubTypes.Type(name = "COMPOUND", value = Compound.class)
})
public abstract class Part implements Serializable {

    private Set<Identifier> identifiers = new HashSet<Identifier>();

    private Label label;

    private UnitOfMeasureCode unitOfMeasure;

    private FormCode form;

    private Set<PartClassificationApplication> classifications = new HashSet<PartClassificationApplication>();

    protected Part() {
    }

    public Set<Identifier> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(Set<Identifier> identifiers) {
        this.identifiers = identifiers;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public UnitOfMeasureCode getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasureCode unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public FormCode getForm() {
        return form;
    }

    public void setForm(FormCode form) {
        this.form = form;
    }

    public Set<PartClassificationApplication> getClassifications() {
        return classifications;
    }

    public void setClassifications(Set<PartClassificationApplication> classifications) {
        this.classifications = classifications;
    }
}
