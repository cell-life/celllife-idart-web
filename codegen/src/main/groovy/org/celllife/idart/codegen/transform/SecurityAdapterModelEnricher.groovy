package org.celllife.idart.codegen.transform

import static org.celllife.idart.codegen.transform.Transformations.toFieldName
import static org.celllife.idart.codegen.transform.Transformations.toPackage

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 21h34
 */
class SecurityAdapterModelEnricher {

    static enrichModelWithSecurityAdapter(baseNamespace, model) {

        def basePackageName = toPackage(baseNamespace)

        model.with {

            /*
             * Security Adapter
             */

            if (securityAdapter == null) {
                securityAdapter = [:]
            }

            securityAdapter.with {

                if (className == null) {
                    className = "${model.entity.className}SecurityAdapter"
                }

                if (packageName == null) {
                    packageName = "${basePackageName}.security.${model.packageName}"
                }

                if (fieldName == null) {
                    fieldName = toFieldName(className)
                }

            }
        }

        model
    }

}
