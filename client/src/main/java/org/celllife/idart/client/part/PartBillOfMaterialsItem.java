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

    public Date fromDate;

    public Date thruDate;

    public Part part;

    public Quantity quantityUsed;

    public String instructions;

    public String comment;

    public PartBillOfMaterialsItem() {
    }
}
