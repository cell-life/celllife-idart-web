package org.celllife.idart.codegen

import static org.celllife.idart.codegen.IdentifiableAggregateRootGenerator.generateIdentifiableAggregateRoot
import static org.celllife.idart.codegen.IdentifiableApplicationServiceBootstrapper.bootstrapIdentifiableApplicationService
import static org.celllife.idart.codegen.IdentifiableResourceGenerator.generateIdentifiableResource
import static org.celllife.idart.codegen.CodeableAggregateRootGenerator.generateCodeableAggregateRoot
import static org.celllife.idart.codegen.CodeableResourceGenerator.generateCodeableResource
import static org.celllife.idart.codegen.CodeableApplicationServiceBootstrapper.bootstrapCodeableApplicationService

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 18h58
 */
class CodeGenerator {

    def groovySourcesDirectory

    def javaSourcesDirectory

    def generatedSourcesDirectory

    def basePackageName

    CodeGenerator(args) {

        this.groovySourcesDirectory = args.groovySourcesDirectory

        this.javaSourcesDirectory = args.javaSourcesDirectory

        this.generatedSourcesDirectory = args.generatedSourcesDirectory

        new File(generatedSourcesDirectory).mkdirs()

        this.basePackageName = args.basePackageName
    }

    void generateIdentifiableAggregateRoot(models) {
        models.each { model -> generateIdentifiableAggregateRoot(groovySourcesDirectory, javaSourcesDirectory, basePackageName, model) }
    }

    void generateCodeableAggregateRoot(models) {
        models.each { model -> generateCodeableAggregateRoot(groovySourcesDirectory, javaSourcesDirectory, basePackageName, model) }
    }

    void generateIdentifiableResources(models) {
        models.each { model ->
            generateIdentifiableResource(groovySourcesDirectory, javaSourcesDirectory, basePackageName, model)
            bootstrapIdentifiableApplicationService(groovySourcesDirectory, javaSourcesDirectory, basePackageName, model)
        }
    }

    void generateCodeableResources(models) {
        models.each { model ->
            generateCodeableResource(groovySourcesDirectory, javaSourcesDirectory, basePackageName, model)
            bootstrapCodeableApplicationService(groovySourcesDirectory, javaSourcesDirectory, basePackageName, model)
        }
    }
}
