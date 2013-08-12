package org.celllife.idart.codegen.transform

import static org.celllife.idart.codegen.transform.Transformations.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 21h34
 */
class IdentifierModelEnricher {

    static enrichModelWithIdentifier(baseNamespace, model) {

        def basePackageName = toPackage(baseNamespace)

        model.with {

            /*
             * Identifier
             */

            if (identifier == null) {
                identifier = [:]
            }

            identifier.with {

                if (shortName == null) {
                    shortName = "Identifier"
                }

                if (name == null) {
                    name = model.name + " " + shortName
                }

                if (className == null) {
                    className = toCamelCase(name)
                }

                if (shortFieldName == null) {
                    shortFieldName = toFieldName(shortName)
                }

                if (fieldName == null) {
                    fieldName = toFieldName(name)
                }

                if (shortFieldName == null) {
                    shortFieldName = toFieldName(shortName)
                }

                if (packageName == null) {
                    packageName = basePackageName + ".common"
                }

                /*
                 * Identifier Properties
                 */

                if (_properties == null) {
                    _properties = [[name: "Value"]]
                }

                _properties.each { property ->

                    /*
                     * Identifier Property
                     */

                    property.with {

                        if (property.name == null) {
                            throw new RuntimeException()
                        }

                        property.with {
                            if (type == null) {
                                type = "String"
                            }
                            if (fieldName == null) {
                                fieldName = toFieldName(property.name)
                            }
                            if (columnName == null) {
                                columnName = toSnakeCase(fieldName)
                            }
                            if (columnType == null) {
                                columnType = "varchar(31)"
                            }
                        }
                    }
                }
            }
        }

        model
    }
}
