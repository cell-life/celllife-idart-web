package org.celllife.idart.codegen.entity

import org.celllife.idart.codegen.FileWriter

import static EntityModelEnricher.enrichAggregateRoot

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 22h35
 */
class EntityApplicationServiceGenerator {

    static generateEntityApplicationService(String groovySourcesDirectory, String basePackageName, model) {

        enrichAggregateRoot(basePackageName, model)

        generateEntityApplicationServiceInterface(groovySourcesDirectory, model)

        generateEntityApplicationServiceImplementation(groovySourcesDirectory, model)
    }

    static generateEntityApplicationServiceInterface(String baseDirectory, model) {
        FileWriter.toFile(
                templateReader: "/templates/entity/applicationServiceInterface.template",
                model: model,
                directory: baseDirectory + "/" + model.applicationService.packageName.replaceAll("\\.", "/"),
                fileName: model.applicationService.className + ".groovy"
        )
    }

    static generateEntityApplicationServiceImplementation(String baseDirectory, model) {
        FileWriter.toFile(
                templateReader: "/templates/entity/applicationServiceImplementation.template",
                model: model,
                directory: baseDirectory + "/" + model.applicationService.packageName.replaceAll("\\.", "/"),
                fileName: model.applicationService.className + "Impl.groovy"
        )
    }
}
