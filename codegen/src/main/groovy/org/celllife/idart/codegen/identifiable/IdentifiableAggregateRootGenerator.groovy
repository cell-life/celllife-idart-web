package org.celllife.idart.codegen.identifiable

import org.celllife.idart.codegen.FileWriter

import static org.celllife.idart.codegen.ModelEnricher.enrichModel

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 20h41
 */
class IdentifiableAggregateRootGenerator {

    static generateIdentifiableAggregateRoot(String groovySourcesDirectory, String basePackageName, model) {

        enrichModel(basePackageName, model)

        generateIdentifiableEntity(groovySourcesDirectory, model)
        generateIdentifiableRepository(groovySourcesDirectory, model)
        generateIdentifiableSequenceInterface(groovySourcesDirectory, model)
        generateIdentifiableValidatorInterface(groovySourcesDirectory, model)
        generateIdentifiableValidationException(groovySourcesDirectory, model)
        generateIdentifiableDomainServiceInterface(groovySourcesDirectory, model)
        generateIdentifiableDomainServiceImplementation(groovySourcesDirectory, model)
    }

    static generateIdentifiableEntity(String baseDirectory, model) {
        FileWriter.toFile(
                templateReader: "/templates/identifable/entity.template",
                model: model,
                directory: baseDirectory + "/" + model.domainPackageName.replaceAll("\\.", "/"),
                fileName: model.entityName + ".groovy"
        )
    }

    static generateIdentifiableRepository(String baseDirectory, model) {
        FileWriter.toFile(
                templateReader: "/templates/identifiable/repository.template",
                model: model,
                directory: baseDirectory + "/" + model.domainPackageName.replaceAll("\\.", "/"),
                fileName: model.entityName + "Repository.groovy"
        )
    }

    static generateIdentifiableSequenceInterface(String baseDirectory, model) {
        FileWriter.toFile(
                templateReader: "/templates/sequenceInterface.template",
                model: model,
                directory: baseDirectory + "/" + model.domainPackageName.replaceAll("\\.", "/"),
                fileName: model.entityName + "Sequence.groovy"
        )
    }

    static generateIdentifiableValidatorInterface(String baseDirectory, model) {
        FileWriter.toFile(
                templateReader: "/templates/validatorInterface.template",
                model: model,
                directory: baseDirectory + "/" + model.domainPackageName.replaceAll("\\.", "/"),
                fileName: model.entityName + "Validator.groovy"
        )
    }

    static generateIdentifiableValidationException(String baseDirectory, model) {
        FileWriter.toFile(
                templateReader: "/templates/validationException.template",
                model: model,
                directory: baseDirectory + "/" + model.domainPackageName.replaceAll("\\.", "/"),
                fileName: model.entityName + "ValidationException.groovy"
        )
    }

    static generateIdentifiableDomainServiceInterface(String baseDirectory, model) {
        FileWriter.toFile(
                templateReader: "/templates/identifiable/domainServiceInterface.template",
                model: model,
                directory: baseDirectory + "/" + model.domainPackageName.replaceAll("\\.", "/"),
                fileName: model.entityName + "Service.groovy"
        )
    }

    static generateIdentifiableDomainServiceImplementation(String baseDirectory, model) {
        FileWriter.toFile(
                templateReader: "/templates/identifiable/domainServiceImplementation.template",
                model: model,
                directory: baseDirectory + "/" + model.domainPackageName.replaceAll("\\.", "/"),
                fileName: model.entityName + "ServiceImpl.groovy"
        )
    }
}
