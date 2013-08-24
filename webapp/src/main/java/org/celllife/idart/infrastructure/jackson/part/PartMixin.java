package org.celllife.idart.infrastructure.jackson.part;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.celllife.idart.domain.part.Compound;
import org.celllife.idart.domain.part.Drug;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-18
 * Time: 20h19
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(name = "drug", value = Drug.class),
        @JsonSubTypes.Type(name = "compound", value = Compound.class),
})
public interface PartMixin {
}
