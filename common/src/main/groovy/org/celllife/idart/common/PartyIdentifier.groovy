package org.celllife.idart.common

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

    static PartyIdentifier valueOf(String string) {

        def pattern = Pattern.compile("([^-]*)-([0-9]*)")
        def matcher = pattern.matcher(string)
        if (!matcher.matches()) {
            throw new RuntimeException("Unknown PartyIdentifier [${string}]")
        }

        new PartyIdentifier(
                value: matcher.group(2),
                type: PartyType.valueOf(matcher.group(1))
        )
    }

    @Override
    String toString() {
        "${type}-${value}"
    }
}