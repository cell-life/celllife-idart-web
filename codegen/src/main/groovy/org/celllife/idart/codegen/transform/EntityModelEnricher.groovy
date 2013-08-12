package org.celllife.idart.codegen.transform

import static org.celllife.idart.codegen.transform.Transformations.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 21h34
 */
class EntityModelEnricher {

    static enrichModelWithEntity(baseNamespace, model) {

        def basePackageName = toPackage(baseNamespace)

        model.with {

            /*
             * Entity
             */

            if (entity == null) {
                entity = [:]
            }

            entity.with() {

                if (className == null) {
                    className = toCamelCase(model.name)
                }

                if (collectionClassName == null) {
                    collectionClassName = toCamelCase(model.namePlural)
                }

                if (packageName == null) {
                    packageName = "${basePackageName}.domain.${model.packageName}"
                }

                if (fieldName == null) {
                    fieldName = toFieldName(model.name)
                }

                if (collectionFieldName == null) {
                    collectionFieldName = toFieldName(model.namePlural)
                }

                if (tableName == null) {
                    tableName = toSnakeCase(className)
                }

                /*
                 * Properties
                 */

                if (_properties == null) {
                    _properties = []
                }

                _properties.each { property ->

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
                        if (unique == null) {
                            unique = false
                        }
                        if (indexed == null) {
                            indexed = false
                        }
                    }
                }
            }
        }

        model
    }
}
