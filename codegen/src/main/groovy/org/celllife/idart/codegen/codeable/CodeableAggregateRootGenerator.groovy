package org.celllife.idart.codegen.codeable

import static org.celllife.idart.codegen.ModelEnricher.enrichModel

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 20h41
 */
class CodeableAggregateRootGenerator {

    static generateCodeableAggregateRoot(String groovySourcesDirectory, String basePackageName, model) {

        enrichModel(basePackageName, model)

        generateCodeableRepository(groovySourcesDirectory, model)
        generateCodeableValidatorInterface(groovySourcesDirectory, model)
        generateCodeableValidationException(groovySourcesDirectory, model)
        generateCodeableDomainServiceInterface(groovySourcesDirectory, model)
        generateCodeableDomainServiceImplementation(groovySourcesDirectory, model)
    }

    static generateCodeableRepository(String baseDirectory, model) {
        org.celllife.idart.codegen.FileWriter.toFile(
                templateReader: "/templates/codeable/repository.template",
                model: model,
                directory: baseDirectory + "/" + model.domainPackageName.replaceAll("\\.", "/"),
                fileName: model.entityName + "Repository.groovy"
        )
    }

    static generateCodeableValidatorInterface(String baseDirectory, model) {
        org.celllife.idart.codegen.FileWriter.toFile(
                templateReader: "/templates/validatorInterface.template",
                model: model,
                directory: baseDirectory + "/" + model.domainPackageName.replaceAll("\\.", "/"),
                fileName: model.entityName + "Validator.groovy"
        )
    }

    static generateCodeableValidationException(String baseDirectory, model) {
        org.celllife.idart.codegen.FileWriter.toFile(
                templateReader: "/templates/validationException.template",
                model: model,
                directory: baseDirectory + "/" + model.domainPackageName.replaceAll("\\.", "/"),
                fileName: model.entityName + "ValidationException.groovy"
        )
    }

    static generateCodeableDomainServiceInterface(String baseDirectory, model) {

        org.celllife.idart.codegen.FileWriter.toFile(
                templateReader: "/templates/codeable/domainServiceInterface.template",
                model: model,
                directory: baseDirectory + "/" + model.domainPackageName.replaceAll("\\.", "/"),
                fileName: model.entityName + "Service.groovy"
        )
    }

    static generateCodeableDomainServiceImplementation(String baseDirectory, model) {

        org.celllife.idart.codegen.FileWriter.toFile(
                templateReader: "/templates/codeable/domainServiceImplementation.template",
                model: model,
                directory: baseDirectory + "/" + model.domainPackageName.replaceAll("\\.", "/"),
                fileName: model.entityName + "ServiceImpl.groovy"
        )
    }
}
