package org.celllife.idart.codegen.transform

import static org.celllife.idart.codegen.transform.Transformations.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 21h34
 */
class DtoAssemblerModelEnricher {

    static enrichModelWithDtoAssembler(baseNamespace, model) {

        def basePackageName = toPackage(baseNamespace)

        model.with {

            /*
             * DTO Assembler
             */

            if (dtoAssembler == null) {
                dtoAssembler = [:]
            }

            dtoAssembler.with() {

                if (className == null) {
                    className = "${toCamelCase(model.name)}DtoAssembler"
                }

                if (packageName == null) {
                    packageName = "${basePackageName}.application.${model.packageName}.dto"
                }

                if (collectionFieldName == null) {
                    collectionFieldName = "${fieldName}s"
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
