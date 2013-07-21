package org.celllife.idart.codegen

import static org.celllife.idart.codegen.ModelEnricher.enrichModel

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 21h31
 */
class CodeableResourceGenerator {

    static generateCodeableResource(String groovySourcesDirectory, String javaSourcesDirectory , String basePackageName, model) {
        enrichModel(basePackageName, model)

        generateCodeableController(groovySourcesDirectory, model)
        generateCodeableResourceInterface(javaSourcesDirectory, model)
    }

    static generateCodeableController(String baseDirectory, model) {

        Output.toFile(
                templateReader: "/templates/codeable/resourceController.template",
                model: model,
                directory: baseDirectory + "/" + model.resourcePackageName.replaceAll("\\.", "/"),
                fileName: model.entityName + "ResourceController.groovy"
        )
    }

    static generateCodeableResourceInterface(String baseDirectory, model) {

        Output.toFile(
                templateReader: "/templates/codeable/resourceServiceInterface.template",
                model: model,
                directory: baseDirectory + "/" + model.applicationPackageName.replaceAll("\\.", "/"),
                fileName: model.entityName + "ResourceService.java"
        )
    }

}
