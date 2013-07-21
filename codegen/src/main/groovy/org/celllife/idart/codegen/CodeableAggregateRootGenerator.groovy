package org.celllife.idart.codegen

import static org.celllife.idart.codegen.CodeableRepositoryGenerator.generateCodeableRepository
import static org.celllife.idart.codegen.CodeableDomainServiceGenerator.generateCodeableDomainService
import static org.celllife.idart.codegen.ModelEnricher.enrichModel

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 20h41
 */
class CodeableAggregateRootGenerator {

    static generateCodeableAggregateRoot(String groovySourcesDirectory, String basePackageName, model) {

        enrichModel(basePackageName, model)

        generateCodeableRepository(groovySourcesDirectory, model)
        generateCodeableDomainService(groovySourcesDirectory, model)
    }
}
