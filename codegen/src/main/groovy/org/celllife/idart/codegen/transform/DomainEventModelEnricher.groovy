package org.celllife.idart.codegen.transform

import static org.celllife.idart.codegen.transform.Transformations.toFieldName
import static org.celllife.idart.codegen.transform.Transformations.toPackage

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 21h34
 */
class DomainEventModelEnricher {

    static enrichModelWithDomainEvent(baseNamespace, model) {

        def basePackageName = toPackage(baseNamespace)

        model.with {

            /*
             * Domain Event
             */

            if (domainEvent == null) {
                domainEvent = [:]
            }

            domainEvent.with {

                if (className == null) {
                    className = "${model.entity.className}Event"
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
