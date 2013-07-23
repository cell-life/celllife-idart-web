package org.celllife.idart.client.part;

import java.util.HashSet;
import java.util.Set;

/**
 * Date: 2013-06-16
 * Time: 18h18
 */
public abstract class FinishedGood extends Part {

    public Set<PartBillOfMaterialsItem> billOfMaterials = new HashSet<PartBillOfMaterialsItem>();

    public FinishedGood() {
    }
}
