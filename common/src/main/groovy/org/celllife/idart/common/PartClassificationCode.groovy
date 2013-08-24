package org.celllife.idart.common

import groovy.transform.EqualsAndHashCode

import java.util.regex.Pattern

/**
 * Party Classification Code
 *
 */
@EqualsAndHashCode
class PartClassificationCode implements Serializable {

    /**
     * Value
     */
    String value

    /**
     * Type
     */
    PartClassificationType type

    static PartClassificationCode valueOf(String string) {

        def pattern = Pattern.compile("([^-]*)-([0-9]*)")
        def matcher = pattern.matcher(string)
        if (!matcher.matches()) {
            throw new RuntimeException("Unknown PartClassificationCode [${string}]")
        }

        new PartClassificationCode(
                value: matcher.group(2),
                type: PartyClassificationType.valueOf(matcher.group(1))
        )
    }

    @Override
    String toString() {
        "${type}-${value}"
    }
}
