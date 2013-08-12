package org.celllife.idart.codegen.transform

import static org.celllife.idart.codegen.transform.Transformations.toFieldName
import static org.celllife.idart.codegen.transform.Transformations.toPackage

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 21h34
 */
class CamelEventPublisherModelEnricher {

    static enrichModelWithCamelEventPublisher(baseNamespace, model) {

        def basePackageName = toPackage(baseNamespace)

        model.with {

            /*
             * Camel Event Publisher Implementation
             */

            if (camelEventPublisher == null) {
                camelEventPublisher = [:]
            }

            camelEventPublisher.with {

                if (className == null) {
                    className = "Camel${model.entity.className}EventPublisher"
                }

                if (packageName == null) {
                    packageName = "${basePackageName}.infrastructure.camel.${model.packageName}"
                }

                if (fieldName == null) {
                    fieldName = toFieldName(className)
                }
            }
        }

        model
    }

}
