package org.celllife.idart.codegen.transform

import static org.celllife.idart.codegen.transform.Transformations.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 21h34
 */
class ModelEnricher {

    static enrichModel(baseNamespace, model) {

        def basePackageName = toPackage(baseNamespace)

        model.with {

            if (name == null) {
                throw new RuntimeException()
            }

            if (description == null) {
                description = null
            }

            if (namePlural == null) {
                namePlural = name + "s"
            }

            if (packageName == null) {
                packageName = name.replaceAll(/ /, '').toLowerCase()
            }

            if (resourcePath == null) {
                resourcePath = toFieldName(namePlural.replaceAll(/ /, ''))
            }

            if (namespace == null) {
                namespace = baseNamespace + "/" + resourcePath
            }
        }

        model
    }
}
