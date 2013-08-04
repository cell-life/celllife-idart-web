package org.celllife.idart.codegen.entity

import static org.celllife.idart.codegen.ModelEnricher.enrichModel

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 21h31
 */
class EntityResourceGenerator {

    static generateEntityResource(String groovySourcesDirectory, String javaSourcesDirectory , String basePackageName, model) {
        enrichModel(basePackageName, model)

        generateEntityController(groovySourcesDirectory, model)
        generateEntityResourceInterface(javaSourcesDirectory, model)
    }

    static generateEntityController(String baseDirectory, model) {

        org.celllife.idart.codegen.FileWriter.toFile(
                templateReader: "/templates/entity/resourceController.template",
                model: model,
                directory: baseDirectory + "/" + model.resourcePackageName.replaceAll("\\.", "/"),
                fileName: model.entityName + "ResourceController.groovy"
        )
    }

    static generateEntityResourceInterface(String baseDirectory, model) {

        org.celllife.idart.codegen.FileWriter.toFile(
                templateReader: "/templates/entity/resourceServiceInterface.template",
                model: model,
                directory: baseDirectory + "/" + model.applicationPackageName.replaceAll("\\.", "/"),
                fileName: model.entityName + "ResourceService.java"
        )
    }

}
