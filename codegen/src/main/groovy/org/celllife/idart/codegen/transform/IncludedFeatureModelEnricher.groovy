package org.celllife.idart.codegen.transform

import static org.celllife.idart.codegen.transform.Transformations.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 21h34
 */
class IncludedFeatureModelEnricher {

    static fullListOfFeatures = [
            "id",
            "entity",
            "repository",
            "validator",
            "jsr303Validator",
            "springDataRepository",
            "domainEvent",
            "eventPublisher",
            "camelEventPublisher",
            "domainService",
            "applicationService",
            "resourceController"
    ]

    static enrichModelWithIncludedFeatures(baseNamespace, model) {

        def basePackageName = toPackage(baseNamespace)

        model.with {

            /*
             * Features
             */

            if (features == null) {
                features = [:]
            }

            features.with {

                if (includes == null) {
                    includes = []
                    includes.addAll(IncludedFeatureModelEnricher.fullListOfFeatures)
                }

                if (excludes != null) {
                    excludes.each { exclude -> includes.remove(exclude) }
                }
            }
        }

        model
    }
}
