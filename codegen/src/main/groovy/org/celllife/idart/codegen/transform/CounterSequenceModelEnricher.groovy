package org.celllife.idart.codegen.transform

import static org.celllife.idart.codegen.transform.Transformations.toFieldName
import static org.celllife.idart.codegen.transform.Transformations.toPackage
import static org.celllife.idart.codegen.transform.Transformations.toSnakeCase

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 21h34
 */
class CounterSequenceModelEnricher {

    static enrichModelWithCounterSequence(baseNamespace, model) {

        def basePackageName = toPackage(baseNamespace)

        model.with {

            /*
             * Repository Interface
             */

            if (counterSequence == null) {
                counterSequence = [:]
            }

            counterSequence.with {

                if (className == null) {
                    className = "Counter${model.entity.className}Sequence"
                }

                if (packageName == null) {
                    packageName = "${basePackageName}.infrastructure.counter.${model.packageName}"
                }

                if (fieldName == null) {
                    fieldName = toFieldName(className)
                }

                if (type == null) {
                    type = toSnakeCase(model.entity.className).toUpperCase()
                }
            }
        }

        model
    }

}
