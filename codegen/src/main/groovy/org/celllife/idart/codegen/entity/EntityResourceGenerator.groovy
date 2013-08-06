package org.celllife.idart.codegen.entity

import static EntityModelEnricher.enrichAggregateRoot

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 21h31
 */
class EntityResourceGenerator {

    static generateEntityResource(String groovySourcesDirectory, String basePackageName, def model) {

        enrichAggregateRoot(basePackageName, model)

        generateEntityController(groovySourcesDirectory, model)
    }

    static generateEntityController(String baseDirectory, model) {

        org.celllife.idart.codegen.FileWriter.toFile(
                templateReader: "/templates/entity/resourceController.template",
                model: model,
                directory: baseDirectory + "/" + model.resourceController.packageName.replaceAll("\\.", "/"),
                fileName: model.resourceController.className + ".groovy"
        )
    }
}
