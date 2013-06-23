package org.celllife.idart.udm.part;

import org.celllife.idart.udm.common.Quantity;
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h19
 */
@Entity
@DiscriminatorValue("Subassembly")
public final class Subassembly extends Part {

    /**
     * Made up of
     */
    @JoinColumn(name = "ForPart")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<PartBillOfMaterialsItem> billOfMaterials;

    public Subassembly() {
    }

    public Subassembly(String name) {
        super(name);
    }

    public Set<PartBillOfMaterialsItem> getBillOfMaterials() {
        return billOfMaterials;
    }

    public void setBillOfMaterials(Set<PartBillOfMaterialsItem> billsOfMaterials) {
        this.billOfMaterials = billsOfMaterials;
    }

    public void addEngineeringPart(Date fromDate, Part engineeringPart, Double quantity, UnitOfMeasure unitOfMeasure) {
        if (this.billOfMaterials == null) {
            this.billOfMaterials = new HashSet<>();
        }

        EngineeringBillOfMaterialsItem engineeringBillOfMaterialsItem = new EngineeringBillOfMaterialsItem();
        engineeringBillOfMaterialsItem.setFromDate(fromDate);
        engineeringBillOfMaterialsItem.setPart(engineeringPart);
        engineeringBillOfMaterialsItem.setQuantityUsed(new Quantity(quantity, unitOfMeasure));

        this.billOfMaterials.add(engineeringBillOfMaterialsItem);

    }
}
