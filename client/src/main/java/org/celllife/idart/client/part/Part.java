package org.celllife.idart.client.part;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.celllife.idart.common.FormCode;
import org.celllife.idart.common.Identifier;
import org.celllife.idart.common.Label;
import org.celllife.idart.common.Quantity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * A Part is generally a Drug or Compound, but could be any medically related artifact. It is
 * something that can be dispensed to a patient as part of a medical treatment.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(name = "DRUG", value = Drug.class),
        @JsonSubTypes.Type(name = "COMPOUND", value = Compound.class)
})
public abstract class Part implements Serializable {

    private static final long serialVersionUID = 5956715929303962419L;

    /**
     * System identification of this Part
     */
    private Set<Identifier> identifiers = new HashSet<Identifier>();

    /**
     * A descriptive label for the Part (Drug or Compound)
     */
    private Label label;
    
    /**
     * Specifies the quantity of the part, e.g. how many capsules or tablets
     */
    private Quantity quantity;

    /**
     * The specific part form (e.g. for drugs: CAP, TAB, SYRUP)
     */
    private FormCode form;

    /**
     * User friendly identification of this Part (e.g. ATC, NAPPI)
     */
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

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
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