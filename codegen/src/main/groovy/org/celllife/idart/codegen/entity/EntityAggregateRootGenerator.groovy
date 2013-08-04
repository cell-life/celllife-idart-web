package org.celllife.idart.codegen.entity

import static org.celllife.idart.codegen.ModelEnricher.enrichModel

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 20h41
 */
class EntityAggregateRootGenerator {

    static generateEntityAggregateRoot(String groovySourcesDirectory, String basePackageName, model) {

        enrichModel(basePackageName, model)

        generateEntity(groovySourcesDirectory, model)
        generateEntityRepository(groovySourcesDirectory, model)
        generateEntityValidatorInterface(groovySourcesDirectory, model)
        generateEntityValidationException(groovySourcesDirectory, model)
        generateEntityDomainServiceInterface(groovySourcesDirectory, model)
        generateEntityDomainServiceImplementation(groovySourcesDirectory, model)
    }

    static generateEntity(String baseDirectory, model) {
        org.celllife.idart.codegen.FileWriter.toFile(
                templateReader: "/templates/entity.template",
                model: model,
                directory: baseDirectory + "/" + model.domainPackageName.replaceAll("\\.", "/"),
                fileName: model.entityName + ".groovy"
        )
    }

    static generateEntityRepository(String baseDirectory, model) {
        org.celllife.idart.codegen.FileWriter.toFile(
                templateReader: "/templates/entity/repository.template",
                model: model,
                directory: baseDirectory + "/" + model.domainPackageName.replaceAll("\\.", "/"),
                fileName: model.entityName + "Repository.groovy"
        )
    }

    static generateEntityValidatorInterface(String baseDirectory, model) {
        org.celllife.idart.codegen.FileWriter.toFile(
                templateReader: "/templates/validatorInterface.template",
                model: model,
                directory: baseDirectory + "/" + model.domainPackageName.replaceAll("\\.", "/"),
                fileName: model.entityName + "Validator.groovy"
        )
    }

    static generateEntityValidationException(String baseDirectory, model) {
        org.celllife.idart.codegen.FileWriter.toFile(
                templateReader: "/templates/validationException.template",
                model: model,
                directory: baseDirectory + "/" + model.domainPackageName.replaceAll("\\.", "/"),
                fileName: model.entityName + "ValidationException.groovy"
        )
    }

    static generateEntityDomainServiceInterface(String baseDirectory, model) {

        org.celllife.idart.codegen.FileWriter.toFile(
                templateReader: "/templates/entity/domainServiceInterface.template",
                model: model,
                directory: baseDirectory + "/" + model.domainPackageName.replaceAll("\\.", "/"),
                fileName: model.entityName + "Service.groovy"
        )
    }

    static generateEntityDomainServiceImplementation(String baseDirectory, model) {

        org.celllife.idart.codegen.FileWriter.toFile(
                templateReader: "/templates/entity/domainServiceImplementation.template",
                model: model,
                directory: baseDirectory + "/" + model.domainPackageName.replaceAll("\\.", "/"),
                fileName: model.entityName + "ServiceImpl.groovy"
        )
    }
}
