package org.celllife.idart.client.part;

import org.celllife.idart.common.Identifier;
import org.celllife.idart.common.PartBillOfMaterialsType;
import org.celllife.idart.common.Period;
import org.celllife.idart.common.Quantity;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Date;
import java.util.Set;

/**
 * Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h34
 */
public class PartBillOfMaterialsItem {

    private PartBillOfMaterialsType type;

    private Period valid;

    private Set<Identifier> part;

    private Quantity quantityUsed;

    private String instructions;

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
