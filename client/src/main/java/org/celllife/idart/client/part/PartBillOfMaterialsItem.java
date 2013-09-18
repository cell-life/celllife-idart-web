package org.celllife.idart.client.part;

import org.celllife.idart.common.Quantity;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Date;

/**
 * Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h34
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(name = "engineering", value = EngineeringPartBillOfMaterialsItem.class)
})
public abstract class PartBillOfMaterialsItem {

    private Date fromDate;

    private Date thruDate;

    private Part part;

    private Quantity quantityUsed;

    private String instructions;

    private String comment;

    public PartBillOfMaterialsItem() {
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getThruDate() {
        return thruDate;
    }

    public void setThruDate(Date thruDate) {
        this.thruDate = thruDate;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
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
