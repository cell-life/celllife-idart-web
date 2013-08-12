package org.celllife.idart.codegen.transform

import java.util.regex.Pattern

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-12
 * Time: 13h43
 */
class Transformations {

    static toPackage(String namespace) {
        def pattern = Pattern.compile(/^http:\/\/www\.([^\/]+)\/(.*)$/)
        def matcher = pattern.matcher(namespace)

        if (!matcher.matches()) {
            throw new RuntimeException()
        }

        def domain = matcher.group(1)
        def domainPackage = domain.split(/\./).reverse().join(".")

        (domainPackage + "." + matcher.group(2).replaceAll("/", ".")).replaceAll(/-/, '')
    }

    static toFieldName(name) {
        name = toCamelCase(name)

        name.substring(0, 1).toLowerCase() + name.substring(1)
    }

    static String toCamelCase(String text) {
        text.replaceAll(/([A-Z])([A-Z]*)[_| ]?([A-Z][a-z])/, { Object[] it -> "${it[1]}${it[2].toLowerCase()}${it[3]}" })
                .replaceAll("([_| ])([A-Za-z0-9])", { Object[] it -> it[2].toUpperCase() })
    }

    static String toSnakeCase(String text) {
        toCamelCase(text)
        // Handles: aB -> a_b
                .replaceAll(/([a-z])([A-Z])/, /$1_$2/)
        // Handles: ABCd -> ab_cd
                .replaceAll(/([A-Z])([A-Z]([a-z]))/, /$1_$2/)
                .toLowerCase()
                .replaceAll(/^_/, '')
    }

    static String toDirectory(String baseDirectory, packageName) {
        baseDirectory + "/" + packageName.replaceAll("\\.", "/")
    }
}
