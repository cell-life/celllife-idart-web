package org.celllife.idart.codegen.entity

import org.celllife.idart.codegen.FileWriter

import static org.celllife.idart.codegen.ModelEnricher.enrichModel

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 22h35
 */
class EntityApplicationServiceGenerator {

    static generateEntityApplicationService(String groovySourcesDirectory, String javaSourcesDirectory, String basePackageName, model) {

        enrichModel(basePackageName, model)

        generateEntityApplicationServiceInterface(javaSourcesDirectory, model)

        generateEntityApplicationServiceImplementation(groovySourcesDirectory, model)
    }

    static generateEntityApplicationServiceInterface(String baseDirectory, model) {
        FileWriter.toFile(
                templateReader: "/templates/entity/applicationServiceInterface.template",
                model: model,
                directory: baseDirectory + "/" + model.applicationPackageName.replaceAll("\\.", "/"),
                fileName: model.entityName + "ApplicationService.java"
        )
    }

    static generateEntityApplicationServiceImplementation(String baseDirectory, model) {
        FileWriter.toFile(
                templateReader: "/templates/entity/applicationServiceImplementation.template",
                model: model,
                directory: baseDirectory + "/" + model.applicationPackageName.replaceAll("\\.", "/"),
                fileName: model.entityName + "ApplicationServiceImpl.groovy"
        )
    }

    static generateEntityApplicationServiceMixin(String baseDirectory, model) {
        FileWriter.toFile(
                templateReader: "/templates/entity/applicationServiceMixin.template",
                model: model,
                directory: baseDirectory + "/" + model.applicationPackageName.replaceAll("\\.", "/"),
                fileName: model.entityName + "ApplicationServiceMixin.groovy",
                overwrite: false
        )
    }
}
