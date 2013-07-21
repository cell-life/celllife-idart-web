package org.celllife.idart.codegen

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

        def directory = baseDirectory + "/" + model.resourcePackageName.replaceAll("\\.", "/")
        def fileName = model.entityName + "ResourceController.groovy"

        Output.toFile(
                templateReader: "/templates/identifiableController.template",
                model: model,
                directory: directory,
                fileName: fileName
        )
    }

    static generateIdentifiableResourceInterface(String baseDirectory, model) {

        def directory = baseDirectory + "/" + model.applicationPackageName.replaceAll("\\.", "/")
        def fileName = model.entityName + "ResourceService.java"

        Output.toFile(
                templateReader: "/templates/identifiableResourceServiceInterface.template",
                model: model,
                directory: directory,
                fileName: fileName
        )
    }

}
