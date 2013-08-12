package org.celllife.idart.codegen.transform

import static org.celllife.idart.codegen.transform.Transformations.toFieldName
import static org.celllife.idart.codegen.transform.Transformations.toPackage

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 21h34
 */
class ApplicationServiceModelEnricher {

    static enrichModelWithApplicationService(baseNamespace, model) {

        def basePackageName = toPackage(baseNamespace)

        model.with {

            /*
             * Application Service Interface
             */

            if (applicationService == null) {
                applicationService = [:]
            }

            applicationService.with {

                if (className == null) {
                    className = "${model.entity.className}ApplicationService"
                }

                if (packageName == null) {
                    packageName = "${basePackageName}.application.${model.packageName}"
                }

                if (fieldName == null) {
                    fieldName = toFieldName(className)
                }

            }
        }

        model
    }

}
