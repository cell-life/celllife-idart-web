package org.celllife.idart.infrastructure.jackson.organisation;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.celllife.idart.application.organisation.dto.InformalOrganisationDto;
import org.celllife.idart.application.organisation.dto.LegalOrganisationDto;
import org.celllife.idart.domain.organisation.InformalOrganisation;
import org.celllife.idart.domain.organisation.LegalOrganisation;
import org.celllife.idart.domain.part.Compound;
import org.celllife.idart.domain.part.Drug;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-18
 * Time: 20h19
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(name = "LEGAL_ORGANISATION", value = LegalOrganisationDto.class),
        @JsonSubTypes.Type(name = "INFORMAL_ORGANISATION", value = InformalOrganisationDto.class),
})
public interface OrganisationDtoMixin {
}
