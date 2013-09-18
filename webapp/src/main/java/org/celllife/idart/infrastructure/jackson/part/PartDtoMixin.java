package org.celllife.idart.infrastructure.jackson.part;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.celllife.idart.application.part.dto.CompoundDto;
import org.celllife.idart.application.part.dto.DrugDto;
import org.celllife.idart.domain.part.Compound;
import org.celllife.idart.domain.part.Drug;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-18
 * Time: 20h19
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(name = "DRUG", value = DrugDto.class),
        @JsonSubTypes.Type(name = "COMPOUND", value = CompoundDto.class),
})
public interface PartDtoMixin {
}
