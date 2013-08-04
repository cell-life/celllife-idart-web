package org.celllife.idart.codegen.identifiable

import org.celllife.idart.codegen.FileWriter

import static org.celllife.idart.codegen.ModelEnricher.enrichModel

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 21h31
 */
class IdentifiableResourceGenerator {

    static generateIdentifiableResource(String groovySourcesDirectory, String javaSourcesDirectory, String basePackageName, model) {
        enrichModel(basePackageName, model)

        generateIdentifiableController(groovySourcesDirectory, model)
        generateIdentifiableResourceInterface(javaSourcesDirectory, model)
    }

    static generateIdentifiableController(String baseDirectory, model) {
        FileWriter.toFile(
                templateReader: "/templates/identifiable/resourceController.template",
                model: model,
                directory: baseDirectory + "/" + model.resourcePackageName.replaceAll("\\.", "/"),
                fileName: model.entityName + "ResourceController.groovy"
        )
    }

    static generateIdentifiableResourceInterface(String baseDirectory, model) {
        FileWriter.toFile(
                templateReader: "/templates/identifiable/resourceServiceInterface.template",
                model: model,
                directory: baseDirectory + "/" + model.applicationPackageName.replaceAll("\\.", "/"),
                fileName: model.entityName + "ResourceService.java"
        )
    }

}
