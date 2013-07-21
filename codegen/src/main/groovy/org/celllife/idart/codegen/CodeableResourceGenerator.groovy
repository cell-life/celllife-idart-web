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

        def directory = baseDirectory + "/" + model.resourcePackageName.replaceAll("\\.", "/")
        def fileName = model.entityName + "ResourceController.groovy"

        Output.toFile(
                templateReader: "/templates/codeableController.template",
                model: model,
                directory: directory,
                fileName: fileName
        )
    }

    static generateCodeableResourceInterface(String baseDirectory, model) {

        def directory = baseDirectory + "/" + model.applicationPackageName.replaceAll("\\.", "/")
        def fileName = model.entityName + "ResourceService.java"

        Output.toFile(
                templateReader: "/templates/codeableResourceServiceInterface.template",
                model: model,
                directory: directory,
                fileName: fileName
        )
    }

}
