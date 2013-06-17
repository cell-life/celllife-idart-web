package org.celllife.idart.udm.part;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h36
 */
@Entity
@DiscriminatorValue("ManufacturingBillOfMaterialsItem")
public final class ManufacturingBillOfMaterialsItem extends PartBillOfMaterialsItem {

    public ManufacturingBillOfMaterialsItem() {
    }

}
