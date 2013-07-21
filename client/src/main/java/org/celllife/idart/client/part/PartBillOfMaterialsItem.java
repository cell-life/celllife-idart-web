package org.celllife.idart.client.part;

import org.celllife.idart.client.common.Quantity;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import java.util.Date;

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-16
 * Time: 18h34
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(name = "engineering", value = EngineeringPartBillOfMaterialsItem.class)
})
public abstract class PartBillOfMaterialsItem {

    public Date fromDate;

    public Date thruDate;

    public Part part;

    public Quantity quantityUsed;

    public String instructions;

    public String comment;

    public PartBillOfMaterialsItem() {
    }
}
