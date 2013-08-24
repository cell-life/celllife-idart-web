package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import javax.annotation.Generated
import java.util.regex.Pattern

/**
 * Party Classification Code
 *
 */
@EqualsAndHashCode
class PartyClassificationCode implements Serializable {

    /**
     * Value
     */
    String value

    /**
     * Type
     */
    PartyClassificationType type

    static PartyClassificationCode valueOf(String string) {

        def pattern = Pattern.compile("([^-]*)-([0-9]*)")
        def matcher = pattern.matcher(string)
        if (!matcher.matches()) {
            throw new RuntimeException("Unknown PartyClassificationCode [${string}]")
        }

        new PartyClassificationCode(
                value: matcher.group(2),
                type: PartyClassificationType.valueOf(matcher.group(1))
        )
    }

    @Override
    String toString() {
        "${type}-${value}"
    }
}
