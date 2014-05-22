package org.celllife.idart.domain.part

import org.celllife.idart.common.*

/**
 * A Part is generally a Drug or Compound, but could be any medically related artifact. It is
 * something that can be dispensed to a patient as part of a medical treatment.
 */
abstract class Part implements Serializable {

    /**
     * Identified by
     */
    PartId id

    /**
     * Labelled as
     */
    Label label
    
    /**
     * Specifies the quantity of the part, how many capsules or tablets
     */
    Quantity quantity;
    
    /**
     * The specific form (e.g. for drugs: CAP, TAB, SYRUP)
     */
    FormCode form;

    /**
     * Classified into
     */
    Set<PartClassificationApplication> classifications = []

    def merge(Part that) {
        if (that == null) {
            return
        }

        this.quantity = that.quantity
        this.label = that.label
        this.form = that.form
        that.classifications?.each { classification -> this.classifications << classification }
    }

    def matches(Part that) {

        if (that == null) {
            return false
        }

        return (this.label.value.toLowerCase() == that.label.value.toLowerCase() 
            & this.quantity == that.quantity 
            & this.form.value.toLowerCase() == that.form.value.toLowerCase());
    }

    def getClassificationCode(PartClassificationType type) {
        for (classification in classifications) {
            if (classification.classification.type == type) {
                return classification.classification
            }
        }
        null
    }

    def addClassification(PartClassificationType type, String code) {
        this.classifications.add(new PartClassificationApplication(classification: new PartClassificationCode(type: type, value: code)))
    }

    @Override
    public String toString() {
        return "Part [id=" + id + ", label=" + label + ", quantity=" + quantity + ", form=" + form
                + ", classifications=" + classifications.toString() + "]";
    }
}
