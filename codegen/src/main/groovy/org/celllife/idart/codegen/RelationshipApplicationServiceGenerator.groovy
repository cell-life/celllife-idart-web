package org.celllife.idart.codegen

import static org.celllife.idart.codegen.RelationshipModelEnricher.enrichRelationshipModel

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 22h35
 */
class RelationshipApplicationServiceGenerator {

    static generateRelationshipApplicationService(String groovySourcesDirectory, String javaSourcesDirectory, String basePackageName, model) {

        enrichRelationshipModel(basePackageName, model)

//        generateRelationshipApplicationServiceInterface(javaSourcesDirectory, model)

        generateRelationshipResourceInterface(javaSourcesDirectory, model)

        generateRelationshipApplicationServiceImplementation(groovySourcesDirectory, model)
    }

    static generateRelationshipApplicationServiceInterface(String baseDirectory, model) {
        Output.toFile(
                templateReader: "/templates/relationship/applicationServiceInterface.template",
                model: model,
                directory: baseDirectory + "/" + model.applicationPackageName.replaceAll("\\.", "/"),
                fileName: model.className + "ApplicationService.java"
        )
    }

    static generateRelationshipApplicationServiceImplementation(String baseDirectory, model) {
        Output.toFile(
                templateReader: "/templates/relationship/applicationServiceImplementation.template",
                model: model,
                directory: baseDirectory + "/" + model.applicationPackageName.replaceAll("\\.", "/"),
                fileName: model.className + "ApplicationServiceImpl.groovy"
        )
    }

    static generateRelationshipResourceInterface(String baseDirectory, model) {

        Output.toFile(
                templateReader: "/templates/relationship/resourceServiceInterface.template",
                model: model,
                directory: baseDirectory + "/" + model.applicationPackageName.replaceAll("\\.", "/"),
                fileName: model.className + "ResourceService.java"
        )
    }
}
