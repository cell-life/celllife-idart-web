package org.celllife.idart.infrastructure.jackson.contactmechanism;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.celllife.idart.domain.contactmechanism.ElectronicAddress;
import org.celllife.idart.domain.contactmechanism.MobileTelephoneNumber;
import org.celllife.idart.domain.contactmechanism.PostalAddress;
import org.celllife.idart.domain.contactmechanism.TelecommunicationsNumber;

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-18
 * Time: 20h19
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(name = "email", value = ElectronicAddress.class),
        @JsonSubTypes.Type(name = "mobile", value = MobileTelephoneNumber.class),
        @JsonSubTypes.Type(name = "postal", value = PostalAddress.class),
        @JsonSubTypes.Type(name = "telephone", value = TelecommunicationsNumber.class)
})
public interface ContactMechanismMixin {
}
