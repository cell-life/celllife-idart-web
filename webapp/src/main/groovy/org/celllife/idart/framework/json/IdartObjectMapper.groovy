package org.celllife.idart.framework.json

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import org.celllife.idart.common.Quantity
import org.celllife.idart.domain.contactmechanism.ContactMechanism
import org.celllife.idart.domain.part.Part
import org.celllife.idart.domain.part.PartBillOfMaterialsItem
import org.celllife.idart.infrastructure.jackson.contactmechanism.ContactMechanismMixin
import org.celllife.idart.infrastructure.jackson.part.PartBillOfMaterialsItemMixin
import org.celllife.idart.infrastructure.jackson.part.PartMixin
import org.celllife.idart.infrastructure.jackson.part.QuantityMixin
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
        addMixInAnnotations(Quantity, QuantityMixin);
        addMixInAnnotations(Part, PartMixin);
        addMixInAnnotations(PartBillOfMaterialsItem, PartBillOfMaterialsItemMixin);
    }
}
