package org.celllife.idart.client.person;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;

/**
 * Kevin W. Sewell
 * Date: 2013-07-18
 * Time: 18h45
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(name = "EMAIL", value = ElectronicAddress.class),
        @JsonSubTypes.Type(name = "MOBILE", value = MobileTelephoneNumber.class),
        @JsonSubTypes.Type(name = "POSTAL", value = PostalAddress.class),
        @JsonSubTypes.Type(name = "TELEPHONE", value = TelecommunicationsNumber.class)
})
public abstract class ContactMechanism implements Serializable {
}
