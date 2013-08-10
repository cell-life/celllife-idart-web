package org.celllife.idart.codegen.entity

import static EntityModelEnricher.enrichAggregateRoot

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 20h41
 */
class EntityAggregateRootGenerator {

    static generateEntityAggregateRoot(String groovySourcesDirectory, String basePackageName, model) {

        enrichAggregateRoot(basePackageName, model)

        generateIdentifier(groovySourcesDirectory, model)
        generateEntity(groovySourcesDirectory, model)
        generateEntityNotFoundException(groovySourcesDirectory, model)
        generateRepository(groovySourcesDirectory, model)
        generateEventPublisherInterface(groovySourcesDirectory, model)
        generateValidatorInterface(groovySourcesDirectory, model)
        generateValidationException(groovySourcesDirectory, model)
        generateDomainServiceInterface(groovySourcesDirectory, model)
        generateDomainServiceImplementation(groovySourcesDirectory, model)
    }

    static generateIdentifier(String baseDirectory, model) {
        org.celllife.idart.codegen.FileWriter.toFile(
                templateReader: "/templates/entity/identifier.template",
                model: model,
                directory: baseDirectory + "/" + model.entity.packageName.replaceAll("\\.", "/"),
                fileName: model.entity.identifier.className + ".groovy"
        )
    }

    static generateEntity(String baseDirectory, model) {
        org.celllife.idart.codegen.FileWriter.toFile(
                templateReader: "/templates/entity/entity.template",
                model: model,
                directory: baseDirectory + "/" + model.entity.packageName.replaceAll("\\.", "/"),
                fileName: model.entity.className + ".groovy"
        )
    }

    static generateEntityNotFoundException(String baseDirectory, model) {
        org.celllife.idart.codegen.FileWriter.toFile(
                templateReader: "/templates/entity/notFoundException.template",
                model: model,
                directory: baseDirectory + "/" + model.entity.packageName.replaceAll("\\.", "/"),
                fileName: model.entity.className + "NotFoundException.groovy"
        )
    }

    static generateRepository(String baseDirectory, model) {
        org.celllife.idart.codegen.FileWriter.toFile(
                templateReader: "/templates/entity/repository.template",
                model: model,
                directory: baseDirectory + "/" + model.repository.packageName.replaceAll("\\.", "/"),
                fileName: model.repository.className + ".groovy"
        )
    }

    static generateEventPublisherInterface(String baseDirectory, model) {
        org.celllife.idart.codegen.FileWriter.toFile(
                templateReader: "/templates/entity/eventPublisher.template",
                model: model,
                directory: baseDirectory + "/" + model.eventPublisher.packageName.replaceAll("\\.", "/"),
                fileName: model.eventPublisher.className + ".groovy"
        )
    }

    static generateValidatorInterface(String baseDirectory, model) {
        org.celllife.idart.codegen.FileWriter.toFile(
                templateReader: "/templates/entity/validator.template",
                model: model,
                directory: baseDirectory + "/" + model.validator.packageName.replaceAll("\\.", "/"),
                fileName: model.validator.className + ".groovy"
        )
    }

    static generateValidationException(String baseDirectory, model) {
        org.celllife.idart.codegen.FileWriter.toFile(
                templateReader: "/templates/entity/validationException.template",
                model: model,
                directory: baseDirectory + "/" +  model.entity.packageName.replaceAll("\\.", "/"),
                fileName: model.entity.className + "ValidationException.groovy"
        )
    }

    static generateDomainServiceInterface(String baseDirectory, model) {

        org.celllife.idart.codegen.FileWriter.toFile(
                templateReader: "/templates/entity/domainServiceInterface.template",
                model: model,
                directory: baseDirectory + "/" + model.domainService.packageName.replaceAll("\\.", "/"),
                fileName: model.domainService.className + ".groovy"
        )
    }

    static generateDomainServiceImplementation(String baseDirectory, model) {

        org.celllife.idart.codegen.FileWriter.toFile(
                templateReader: "/templates/entity/domainServiceImplementation.template",
                model: model,
                directory: baseDirectory + "/" + model.domainService.packageName.replaceAll("\\.", "/"),
                fileName: model.domainService.className + "Impl.groovy"
        )
    }
}
