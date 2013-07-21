package org.celllife.idart.infrastructure.part.json;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.celllife.idart.domain.common.Codeable;
import org.celllife.idart.domain.contactmechanism.ElectronicAddress;
import org.celllife.idart.domain.contactmechanism.MobileTelephoneNumber;
import org.celllife.idart.domain.contactmechanism.PostalAddress;
import org.celllife.idart.domain.contactmechanism.TelecommunicationsNumber;
import org.celllife.idart.domain.form.Form;
import org.celllife.idart.domain.part.*;
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasure;
import org.celllife.idart.framework.json.CodeableSerializer;
import org.celllife.idart.framework.json.IdentifiableSerializer;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-18
 * Time: 20h19
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(name = "drug", value = Drug.class),
        @JsonSubTypes.Type(name = "drugGroup", value = DrugGroup.class),
        @JsonSubTypes.Type(name = "compound", value = Compound.class),
})
public interface PartMixin {

    @JsonSerialize(using = CodeableSerializer.class)
    UnitOfMeasure getUnitOfMeasure();

    @JsonSerialize(using = CodeableSerializer.class)
    Form getForm();

}
