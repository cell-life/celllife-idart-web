package org.celllife.idart.codegen

import static IdentifiableDomainServiceGenerator.generateIdentifiableDomainService
import static org.celllife.idart.codegen.ModelEnricher.enrichModel
import static IdentifiableRepositoryGenerator.generateIdentifiableRepository

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 20h41
 */
class IdentifiableAggregateRootGenerator {

    static generateIdentifiableAggregateRoot(String groovySourcesDirectory, String generatedSourcesDirectory, String basePackageName, model) {

        enrichModel(basePackageName, model)

        if (model.skipRepository != null || !model.skipRepository) {
            generateIdentifiableRepository(generatedSourcesDirectory, model)
        }
        generateIdentifiableDomainService(groovySourcesDirectory, generatedSourcesDirectory, model)
    }
}
