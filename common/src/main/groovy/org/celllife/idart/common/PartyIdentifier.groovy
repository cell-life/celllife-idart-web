package org.celllife.idart.common

import com.fasterxml.jackson.annotation.JsonValue
import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated
import java.util.regex.Pattern

/**
 * Part Identifier
 *
 */
@EqualsAndHashCode
class PartyIdentifier implements Serializable {

    /**
     * Value
     */
    String value

    /**
     * Type
     */
    PartyType type

    static PartyIdentifier valueOf(String identifierValue) {
        def identifier = new PartyIdentifier()
        identifier.setIdentifierValue(identifierValue)
        identifier
    }

    @JsonValue
    String getIdentifierValue() {
        "${type}-${value}"
    }

    void setIdentifierValue(String identifierValue) {

        def pattern = Pattern.compile("([^-]*)-([0-9]*)")
        def matcher = pattern.matcher(identifierValue)
        if (!matcher.matches()) {
            throw new RuntimeException("Unknown Party Identifier [${identifierValue}]")
        }

        this.type = PartyType.valueOf(matcher.group(1))
        this.value = matcher.group(2)
    }

    @Override
    String toString() {
        identifierValue
    }
}