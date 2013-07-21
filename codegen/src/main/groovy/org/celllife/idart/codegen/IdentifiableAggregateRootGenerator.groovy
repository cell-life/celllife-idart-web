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

    static generateIdentifiableAggregateRoot(String groovySourcesDirectory, String basePackageName, model) {

        enrichModel(basePackageName, model)

        generateIdentifiableRepository(groovySourcesDirectory, model)
        generateIdentifiableDomainService(groovySourcesDirectory, model)
    }
}
