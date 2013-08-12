package org.celllife.idart.codegen.transform

import static org.celllife.idart.codegen.transform.Transformations.toFieldName
import static org.celllife.idart.codegen.transform.Transformations.toPackage

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 21h34
 */
class ResourceControllerServiceModelEnricher {

    static enrichModelWithResourceController(baseNamespace, model) {

        def basePackageName = toPackage(baseNamespace)

        model.with {

            /*
             * Controller
             */

            if (resourceController == null) {
                resourceController = [:]
            }

            resourceController.with {

                if (className == null) {
                    className = "${model.entity.className}ResourceController"
                }

                if (packageName == null) {
                    packageName = "${basePackageName}.interfaces.resource.${model.packageName}"
                }

                if (fieldName == null) {
                    fieldName = toFieldName(className)
                }

            }
        }

        model
    }

}
