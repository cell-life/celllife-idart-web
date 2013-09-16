package org.celllife.idart.client.person;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

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
