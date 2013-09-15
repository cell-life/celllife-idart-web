package org.celllife.idart.codegen.transform

import static org.celllife.idart.codegen.transform.Transformations.toFieldName
import static org.celllife.idart.codegen.transform.Transformations.toPackage

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 21h34
 */
class SequenceModelEnricher {

    static enrichModelWithSequence(baseNamespace, model) {

        def basePackageName = toPackage(baseNamespace)

        model.with {

            /*
             * Repository Interface
             */

            if (sequence == null) {
                sequence = [:]
            }

            sequence.with {

                if (className == null) {
                    className = "${model.entity.className}Sequence"
                }

                if (packageName == null) {
                    packageName = "${basePackageName}.domain.${model.packageName}"
                }

                if (fieldName == null) {
                    fieldName = toFieldName(className)
                }
            }
        }

        model
    }

}
