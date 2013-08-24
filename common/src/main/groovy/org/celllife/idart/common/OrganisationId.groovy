package org.celllife.idart.common

import com.fasterxml.jackson.annotation.JsonValue
import groovy.transform.EqualsAndHashCode

/**
 * Organisation Id
 *
 */
@EqualsAndHashCode
class OrganisationId implements Serializable {

    /**
     * Value
     */
    String value

    static OrganisationId valueOf(String value) {
        return new OrganisationId(value: value)
    }

    @JsonValue
    String getValue() {
        value
    }
}
