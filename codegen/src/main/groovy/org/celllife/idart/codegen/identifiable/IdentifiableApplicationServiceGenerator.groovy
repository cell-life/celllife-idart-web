package org.celllife.idart.codegen.identifiable

import org.celllife.idart.codegen.FileWriter

import static org.celllife.idart.codegen.ModelEnricher.enrichModel

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 22h35
 */
class IdentifiableApplicationServiceGenerator {

    static generateIdentifiableApplicationService(String groovySourcesDirectory, String javaSourcesDirectory, String basePackageName, model) {

        enrichModel(basePackageName, model)

        generateIdentifiableApplicationServiceInterface(javaSourcesDirectory, model)

        generateIdentifiableApplicationServiceImplementation(groovySourcesDirectory, model)
    }

    static generateIdentifiableApplicationServiceInterface(String baseDirectory, model) {
        FileWriter.toFile(
                templateReader: "/templates/identifiable/applicationServiceInterface.template",
                model: model,
                directory: baseDirectory + "/" + model.applicationPackageName.replaceAll("\\.", "/"),
                fileName: model.entityName + "ApplicationService.java",
                overwrite: false
        )
    }

    static generateIdentifiableApplicationServiceImplementation(String baseDirectory, model) {
        FileWriter.toFile(
                templateReader: "/templates/identifiable/applicationServiceImplementation.template",
                model: model,
                directory: baseDirectory + "/" + model.applicationPackageName.replaceAll("\\.", "/"),
                fileName: model.entityName + "ApplicationServiceImpl.groovy"
        )
    }

    static generateIdentifiableApplicationServiceMixin(String baseDirectory, model) {
        FileWriter.toFile(
                templateReader: "/templates/identifiable/applicationServiceMixin.template",
                model: model,
                directory: baseDirectory + "/" + model.applicationPackageName.replaceAll("\\.", "/"),
                fileName: model.entityName + "ApplicationServiceMixin.groovy"
        )
    }
}
