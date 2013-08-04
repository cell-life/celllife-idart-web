package org.celllife.idart.codegen.codeable

import org.celllife.idart.codegen.FileWriter

import static org.celllife.idart.codegen.ModelEnricher.enrichModel

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 22h35
 */
class CodeableApplicationServiceGenerator {

    static generateCodeableApplicationService(String groovySourcesDirectory, String javaSourcesDirectory, String basePackageName, model) {

        enrichModel(basePackageName, model)

        generateCodeableApplicationServiceInterface(javaSourcesDirectory, model)

        generateCodeableApplicationServiceImplementation(groovySourcesDirectory, model)
    }

    static generateCodeableApplicationServiceInterface(String baseDirectory, model) {
        FileWriter.toFile(
                templateReader: "/templates/codeable/applicationServiceInterface.template",
                model: model,
                directory: baseDirectory + "/" + model.applicationPackageName.replaceAll("\\.", "/"),
                fileName: model.entityName + "ApplicationService.java"
        )
    }

    static generateCodeableApplicationServiceImplementation(String baseDirectory, model) {
        FileWriter.toFile(
                templateReader: "/templates/codeable/applicationServiceImplementation.template",
                model: model,
                directory: baseDirectory + "/" + model.applicationPackageName.replaceAll("\\.", "/"),
                fileName: model.entityName + "ApplicationServiceImpl.groovy"
        )
    }

    static generateCodeableApplicationServiceMixin(String baseDirectory, model) {
        FileWriter.toFile(
                templateReader: "/templates/codeable/applicationServiceMixin.template",
                model: model,
                directory: baseDirectory + "/" + model.applicationPackageName.replaceAll("\\.", "/"),
                fileName: model.entityName + "ApplicationServiceMixin.groovy",
                overwrite: false
        )
    }
}
