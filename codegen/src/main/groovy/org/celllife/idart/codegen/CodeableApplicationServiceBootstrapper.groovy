package org.celllife.idart.codegen

import static org.celllife.idart.codegen.ModelEnricher.enrichModel

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 22h35
 */
class CodeableApplicationServiceBootstrapper {

    static bootstrapCodeableApplicationService(String groovySourcesDirectory, String javaSourcesDirectory, String basePackageName, model) {

        enrichModel(basePackageName, model)

        bootstrapCodeableApplicationServiceInterface(javaSourcesDirectory, model)

        bootstrapCodeableApplicationServiceImplementation(groovySourcesDirectory, model)

        generateCodeableApplicationServiceMixin(groovySourcesDirectory, model)
    }

    static bootstrapCodeableApplicationServiceInterface(String baseDirectory, model) {
        def directory = baseDirectory + "/" + model.applicationPackageName.replaceAll("\\.", "/")
        def fileName = model.entityName + "ApplicationService.java"

        Output.toFile(
                templateReader: "/templates/codeableApplicationServiceInterface.template",
                model: model,
                directory: directory,
                fileName: fileName,
                overwrite: false
        )
    }

    static bootstrapCodeableApplicationServiceImplementation(String baseDirectory, model) {
        def directory = baseDirectory + "/" + model.applicationPackageName.replaceAll("\\.", "/")
        def fileName = model.entityName + "ApplicationServiceImpl.groovy"

        Output.toFile(
                templateReader: "/templates/codeableApplicationServiceImplementation.template",
                model: model,
                directory: directory,
                fileName: fileName,
                overwrite: false
        )
    }

    static generateCodeableApplicationServiceMixin(String baseDirectory, model) {
        def directory = baseDirectory + "/" + model.applicationPackageName.replaceAll("\\.", "/")
        def fileName = model.entityName + "ApplicationServiceMixin.groovy"

        Output.toFile(
                templateReader: "/templates/codeableApplicationServiceMixin.template",
                model: model,
                directory: directory,
                fileName: fileName,
                overwrite: false
        )
    }
}
