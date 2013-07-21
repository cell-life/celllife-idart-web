package org.celllife.idart.codegen

import static org.celllife.idart.codegen.ModelEnricher.enrichModel

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 22h35
 */
class IdentifiableApplicationServiceBootstrapper {

    static bootstrapIdentifiableApplicationService(String groovySourcesDirectory, String javaSourcesDirectory, String basePackageName, model) {

        enrichModel(basePackageName, model)

        bootstrapIdentifiableApplicationServiceInterface(javaSourcesDirectory, model)

        bootstrapIdentifiableApplicationServiceImplementation(groovySourcesDirectory, model)

        generateIdentifiableApplicationServiceMixin(groovySourcesDirectory, model)
    }

    static bootstrapIdentifiableApplicationServiceInterface(String baseDirectory, model) {
        def directory = baseDirectory + "/" + model.applicationPackageName.replaceAll("\\.", "/")
        def fileName = model.entityName + "ApplicationService.java"

        Output.toFile(
                templateReader: "/templates/identifiableApplicationServiceInterface.template",
                model: model,
                directory: directory,
                fileName: fileName,
                overwrite: false
        )
    }

    static bootstrapIdentifiableApplicationServiceImplementation(String baseDirectory, model) {
        def directory = baseDirectory + "/" + model.applicationPackageName.replaceAll("\\.", "/")
        def fileName = model.entityName + "ApplicationServiceImpl.groovy"

        Output.toFile(
                templateReader: "/templates/identifiableApplicationServiceImplementation.template",
                model: model,
                directory: directory,
                fileName: fileName
        )
    }

    static generateIdentifiableApplicationServiceMixin(String baseDirectory, model) {
        def directory = baseDirectory + "/" + model.applicationPackageName.replaceAll("\\.", "/")
        def fileName = model.entityName + "ApplicationServiceMixin.groovy"

        Output.toFile(
                templateReader: "/templates/identifiableApplicationServiceMixin.template",
                model: model,
                directory: directory,
                fileName: fileName
        )
    }
}
