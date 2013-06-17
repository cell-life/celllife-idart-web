package org.celllife.idart.udm.facility;

import org.celllife.idart.udm.common.Quantity;
import org.celllife.idart.udm.common.BaseEntity;

import javax.persistence.*;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 11h03
 */
@Entity
@Inheritance
@DiscriminatorColumn(name = "type")
public abstract class Facility extends BaseEntity {

    private String description;

    @AttributeOverride(name = "value", column = @Column(name = "area"))
    @AssociationOverride(name = "unitOfMeasure", joinColumns = @JoinColumn(name = "areaUom"))
    private Quantity area;

    protected Facility() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Quantity getArea() {
        return area;
    }

    public void setArea(Quantity area) {
        this.area = area;
    }
}
