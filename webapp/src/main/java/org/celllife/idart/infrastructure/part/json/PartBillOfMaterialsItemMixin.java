package org.celllife.idart.infrastructure.part.json;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.celllife.idart.domain.part.EngineeringPartBillOfMaterialsItem;
import org.celllife.idart.domain.part.Part;
import org.celllife.idart.framework.json.IdentifiableSerializer;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(name = "engineering", value = EngineeringPartBillOfMaterialsItem.class)
})
public interface PartBillOfMaterialsItemMixin {

    @JsonIgnore
    Long getPk();

    @JsonSerialize(using = IdentifiableSerializer.class)
    Part getPart();

}