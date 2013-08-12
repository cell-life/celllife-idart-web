package org.celllife.idart.codegen.transform

import static org.celllife.idart.codegen.transform.Transformations.toFieldName
import static org.celllife.idart.codegen.transform.Transformations.toPackage

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 21h34
 */
class SpringDataRepositoryModelEnricher {

    static enrichModelWithSpringDataRepository(baseNamespace, model) {

        def basePackageName = toPackage(baseNamespace)

        model.with {

            /*
             * Spring Data Repository Implementation
             */

            if (springDataRepository == null) {
                springDataRepository = [:]
            }

            springDataRepository.with {

                if (className == null) {
                    className = "SpringData${model.entity.className}Repository"
                }

                if (packageName == null) {
                    packageName = "${basePackageName}.infrastructure.springdata.${model.packageName}"
                }

                if (fieldName == null) {
                    fieldName = toFieldName(className)
                }
            }
        }

        model
    }
}
