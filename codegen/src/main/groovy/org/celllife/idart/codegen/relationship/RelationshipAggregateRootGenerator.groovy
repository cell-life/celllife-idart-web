package org.celllife.idart.codegen.relationship

import static org.celllife.idart.codegen.relationship.RelationshipModelEnricher.enrichRelationshipModel

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 20h41
 */
class RelationshipAggregateRootGenerator {

    static generateRelationshipAggregateRoot(String groovySourcesDirectory, String basePackageName, model) {

        enrichRelationshipModel(basePackageName, model)

        generateRelationshipEntity(groovySourcesDirectory, model)
        generateRelationshipRepository(groovySourcesDirectory, model)
        generateRelationshipDomainServiceInterface(groovySourcesDirectory, model)
        generateRelationshipDomainServiceImplementation(groovySourcesDirectory, model)
    }

    static generateRelationshipEntity(String baseDirectory, model) {
        org.celllife.idart.codegen.FileWriter.toFile(
                templateReader: "/templates/relationship/entity.template",
                model: model,
                directory: baseDirectory + "/" + model.domainPackageName.replaceAll("\\.", "/"),
                fileName: model.className + ".groovy"
        )
    }

    static generateRelationshipRepository(String baseDirectory, model) {
        org.celllife.idart.codegen.FileWriter.toFile(
                templateReader: "/templates/relationship/repository.template",
                model: model,
                directory: baseDirectory + "/" + model.domainPackageName.replaceAll("\\.", "/"),
                fileName: model.className + "Repository.groovy"
        )
    }

    static generateRelationshipDomainServiceInterface(String baseDirectory, model) {
        org.celllife.idart.codegen.FileWriter.toFile(
                templateReader: "/templates/relationship/domainServiceInterface.template",
                model: model,
                directory: baseDirectory + "/" + model.domainPackageName.replaceAll("\\.", "/"),
                fileName: model.className + "Service.groovy"
        )
    }

    static generateRelationshipDomainServiceImplementation(String baseDirectory, model) {
        org.celllife.idart.codegen.FileWriter.toFile(
                templateReader: "/templates/relationship/domainServiceImplementation.template",
                model: model,
                directory: baseDirectory + "/" + model.domainPackageName.replaceAll("\\.", "/"),
                fileName: model.className + "ServiceImpl.groovy"
        )
    }
}
