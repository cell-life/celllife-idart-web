package org.celllife.idart.codegen.transform

import static org.celllife.idart.codegen.transform.Transformations.toFieldName
import static org.celllife.idart.codegen.transform.Transformations.toPackage

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 21h34
 */
class Jsr303ValidatorModelEnricher {

    static enrichModelWithJsr303Validator(baseNamespace, model) {

        def basePackageName = toPackage(baseNamespace)

        model.with {

            /*
             * JSR 303 Validator Implementation
             */

            if (jsr303Validator == null) {
                jsr303Validator = [:]
            }

            jsr303Validator.with {

                if (className == null) {
                    className = "Jsr303${model.entity.className}Validator"
                }

                if (packageName == null) {
                    packageName = "${basePackageName}.infrastructure.jsr303.${model.packageName}"
                }

                if (fieldName == null) {
                    fieldName = toFieldName(className)
                }
            }
        }

        model
    }

}
