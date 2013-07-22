package org.celllife.idart.codegen

import static org.celllife.idart.codegen.CodeableSpringDataRepositoryGenerator.generateCodeableSpringDataRepository

import static org.celllife.idart.codegen.IdentifiableAggregateRootGenerator.generateIdentifiableAggregateRoot
import static IdentifiableApplicationServiceGenerator.generateIdentifiableApplicationService
import static org.celllife.idart.codegen.IdentifiableResourceGenerator.generateIdentifiableResource
import static org.celllife.idart.codegen.CodeableAggregateRootGenerator.generateCodeableAggregateRoot
import static org.celllife.idart.codegen.CodeableResourceGenerator.generateCodeableResource
import static CodeableApplicationServiceGenerator.generateCodeableApplicationService
import static org.celllife.idart.codegen.IdentifiableSpringDataRepositoryGenerator.generateIdentifiableSpringDataRepository

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 18h58
 */
class CodeGenerator {

    def groovySourcesDirectory

    def javaSourcesDirectory

    def basePackageName

    CodeGenerator(args) {

        this.groovySourcesDirectory = args.groovySourcesDirectory

        this.javaSourcesDirectory = args.javaSourcesDirectory

        this.basePackageName = args.basePackageName
    }

    def generateCounterSequence(models) {
        models.each { model ->
            CounterSequenceGenerator.generateCounterSequence(groovySourcesDirectory, model)
        }
    }

    def generateHibernateValidator(models) {
        models.each { model ->
            HibernateValidatorGenerator.generateHibernateValidator(groovySourcesDirectory, model)
        }
    }

    def generateIdentifiableResources(models) {
        models.each { model ->
            generateIdentifiableResource(groovySourcesDirectory, javaSourcesDirectory, basePackageName, model)
            generateIdentifiableApplicationService(groovySourcesDirectory, javaSourcesDirectory, basePackageName, model)
        }
    }

    def generateIdentifiableAggregateRoot(models) {
        models.each { model -> generateIdentifiableAggregateRoot(groovySourcesDirectory, basePackageName, model) }
    }

    def generateIdentifiableSpringDataRepositories(models) {
        models.each { model ->
            ModelEnricher.enrichModel(basePackageName, model)
            generateIdentifiableSpringDataRepository(javaSourcesDirectory, model) }
    }

    def generateCodeableResources(models) {
        models.each { model ->
            generateCodeableResource(groovySourcesDirectory, javaSourcesDirectory, basePackageName, model)
            generateCodeableApplicationService(groovySourcesDirectory, javaSourcesDirectory, basePackageName, model)
        }
    }

    def generateCodeableAggregateRoot(models) {
        models.each { model -> generateCodeableAggregateRoot(groovySourcesDirectory, basePackageName, model) }
    }

    def generateCodeableSpringDataRepositories(models) {
        models.each { model ->
            ModelEnricher.enrichModel(basePackageName, model)
            generateCodeableSpringDataRepository(javaSourcesDirectory, model)
        }
    }
}
