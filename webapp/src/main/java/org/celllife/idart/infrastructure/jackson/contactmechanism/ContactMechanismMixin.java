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
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(name = "EMAIL", value = ElectronicAddress.class),
        @JsonSubTypes.Type(name = "MOBILE", value = MobileTelephoneNumber.class),
        @JsonSubTypes.Type(name = "POSTAL", value = PostalAddress.class),
        @JsonSubTypes.Type(name = "TELEPHONE", value = TelecommunicationsNumber.class)
})
public interface ContactMechanismMixin {
}
