package org.celllife.idart.codegen.transform

import static org.celllife.idart.codegen.transform.Transformations.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 21h34
 */
class RepositoryModelEnricher {

    static enrichModelWithRepository(baseNamespace, model) {

        def basePackageName = toPackage(baseNamespace)

        model.with {

            /*
             * Repository Interface
             */

            if (repository == null) {
                repository = [:]
            }

            repository.with {

                if (className == null) {
                    className = "${model.entity.className}Repository"
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
