package org.celllife.idart.client.person;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import java.io.Serializable;

/**
 * Kevin W. Sewell
 * Date: 2013-07-18
 * Time: 18h45
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(name = "email", value = ElectronicAddress.class),
        @JsonSubTypes.Type(name = "mobile", value = MobileTelephoneNumber.class),
        @JsonSubTypes.Type(name = "postal", value = PostalAddress.class),
        @JsonSubTypes.Type(name = "telephone", value = TelecommunicationsNumber.class)
})
public abstract class ContactMechanism implements Serializable {
}
