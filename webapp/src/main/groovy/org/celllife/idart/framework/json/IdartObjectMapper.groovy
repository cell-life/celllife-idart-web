package org.celllife.idart.framework.json

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import org.celllife.idart.application.organisation.dto.OrganisationDto
import org.celllife.idart.application.part.dto.PartDto
import org.celllife.idart.application.product.dto.ProductDto
import org.celllife.idart.domain.contactmechanism.ContactMechanism
import org.celllife.idart.infrastructure.jackson.contactmechanism.ContactMechanismMixin
import org.celllife.idart.infrastructure.jackson.organisation.OrganisationDtoMixin
import org.celllife.idart.infrastructure.jackson.part.PartDtoMixin
import org.celllife.idart.infrastructure.jackson.product.ProductDtoMixin
import org.springframework.stereotype.Component

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-22
 * Time: 20h23
 */
@Component
class IdartObjectMapper extends ObjectMapper {

    IdartObjectMapper() {

        setSerializationInclusion(JsonInclude.Include.NON_NULL)

        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

        addMixInAnnotations(ContactMechanism, ContactMechanismMixin);
        addMixInAnnotations(PartDto, PartDtoMixin);
        addMixInAnnotations(ProductDto, ProductDtoMixin);
        addMixInAnnotations(OrganisationDto, OrganisationDtoMixin);
    }
}
