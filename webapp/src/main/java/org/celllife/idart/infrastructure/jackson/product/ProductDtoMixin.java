package org.celllife.idart.infrastructure.jackson.product;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.celllife.idart.application.organisation.dto.InformalOrganisationDto;
import org.celllife.idart.application.organisation.dto.LegalOrganisationDto;
import org.celllife.idart.application.product.dto.MedicationDto;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-18
 * Time: 20h19
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(name = "MEDICATION", value = MedicationDto.class)
})
public interface ProductDtoMixin {
}
