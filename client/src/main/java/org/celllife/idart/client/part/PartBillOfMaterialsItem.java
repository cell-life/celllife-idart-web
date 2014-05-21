package org.celllife.idart.client.part;

import java.util.Set;

import org.celllife.idart.common.Identifier;
import org.celllife.idart.common.PartBillOfMaterialsType;
import org.celllife.idart.common.Period;
import org.celllife.idart.common.Quantity;

/**
 * The PartBillOfMaterialsItem is used to describe the parts of a Drug that make up the chemical composition.
 */
public class PartBillOfMaterialsItem {

    /**
     * FIXME: wtf does this mean?
     */
    private PartBillOfMaterialsType type;

    /**
     * The expiry date
     */
    private Period valid;

    /**
     * Identifies the part to which this item belongs
     */
    private Set<Identifier> part;

    /**
     * How many are or how much is included
     */
    private Quantity quantityUsed;

    /**
     * Guidelines on how to use the drug properly
     */
    private String instructions;

    /**
     * A random comment for good luck
     */
    private String comment;

    public PartBillOfMaterialsItem() {
    }

    public PartBillOfMaterialsType getType() {
        return type;
    }

    public void setType(PartBillOfMaterialsType type) {
        this.type = type;
    }

    public Period getValid() {
        return valid;
    }

    public void setValid(Period valid) {
        this.valid = valid;
    }

    public Set<Identifier> getPart() {
        return part;
    }

    public void setPart(Set<Identifier> part) {
        this.part = part;
    }

    public Quantity getQuantityUsed() {
        return quantityUsed;
    }

    public void setQuantityUsed(Quantity quantityUsed) {
        this.quantityUsed = quantityUsed;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}