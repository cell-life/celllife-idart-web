package org.celllife.idart.udm.part;

import org.celllife.idart.udm.common.Quantity;
import org.celllife.idart.udm.common.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h34
 */
@Entity
@Inheritance
@DiscriminatorColumn(name = "type")
public abstract class PartBillOfMaterialsItem extends BaseEntity {

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fromDate;

    @Temporal(TemporalType.DATE)
    private Date thruDate;

    @NotNull
    @ManyToOne
    private Part part;

    @AttributeOverride(name = "value", column = @Column(name = "quantityUsed"))
    @AssociationOverride(name = "unitOfMeasure", joinColumns = @JoinColumn(name = "quantityUsedUom"))
    private Quantity quantityUsed;

    private String instructions;

    private String comment;

    protected PartBillOfMaterialsItem() {
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
