package org.celllife.idart.codegen.entity

import static org.celllife.idart.codegen.FileWriter.toFile
import static org.celllife.idart.codegen.entity.EntityModelTransform.transform

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 20h41
 */
class EntityCodeGenerator {

    static generateEntityCode(String baseDirectory, String baseNamespace, model) {

        transform(baseNamespace, model)

        model.features.each { feature ->

            switch (feature) {
                case "entity":
                    generateEntity(baseDirectory, model)
                    break
                case "repository":
                    generateRepository(baseDirectory, model)
                    generateEntityNotFoundException(baseDirectory, model)
                    break
                case "eventPublisher":
                    generateEventPublisherInterface(baseDirectory, model)
                    break
                case "validator":
                    generateValidatorInterface(baseDirectory, model)
                    generateValidationException(baseDirectory, model)
                    break
                case "domainService":
                    generateDomainServiceInterface(baseDirectory, model)
                    generateDomainServiceImplementation(baseDirectory, model)
                    break
                case "applicationService":
                    generateApplicationServiceInterface(baseDirectory, model)
                    generateApplicationServiceImplementation(baseDirectory, model)
                    break
                case "identifier":
                    generateIdentifier(baseDirectory, model)
                    break
                case "jsr303Validator":
                    generateJsr303Validator(baseDirectory, model)
                    break
                case "resourceController":
                    generateResourceController(baseDirectory, model)
                    break
                case "springDataRepository":
                    generateSpringDataRepository()
                    break
                case "": break
            }

        }
    }

    static generateIdentifier(String baseDirectory, model) {
        toFile(
                templateReader: "/templates/entity/identifier.template",
                model: model,
                directory: baseDirectory + "/domain/src/main/groovy/" + model.identifier.packageName.replaceAll("\\.", "/"),
                fileName: model.identifier.className + ".groovy"
        )
    }

    static generateEntity(String baseDirectory, model) {
        toFile(
                templateReader: "/templates/entity/entity.template",
                model: model,
                directory: baseDirectory + "/domain/src/main/groovy/" + model.entity.packageName.replaceAll("\\.", "/"),
                fileName: model.entity.className + ".groovy"
        )
    }

    static generateEntityNotFoundException(String baseDirectory, model) {
        toFile(
                templateReader: "/templates/entity/notFoundException.template",
                model: model,
                directory: baseDirectory + "/domain/src/main/groovy/" + model.entity.packageName.replaceAll("\\.", "/"),
                fileName: model.entity.className + "NotFoundException.groovy"
        )
    }

    static generateRepository(String baseDirectory, model) {
        toFile(
                templateReader: "/templates/entity/repository.template",
                model: model,
                directory: baseDirectory + "/domain/src/main/groovy/" + model.repository.packageName.replaceAll("\\.", "/"),
                fileName: model.repository.className + ".groovy"
        )
    }

    static generateSpringDataRepository(String baseDirectory, model) {
        toFile(
                templateReader: "/templates/entity/springDataRepository.template",
                model: model,
                directory: baseDirectory + "/webapp/src/main/java/" + model.springDataRepository.packageName.replaceAll("\\.", "/"),
                fileName: model.springDataRepository.className + ".java"
        )
    }

    static generateEventPublisherInterface(String baseDirectory, model) {
        toFile(
                templateReader: "/templates/entity/eventPublisher.template",
                model: model,
                directory: baseDirectory + "/domain/src/main/groovy/" + model.eventPublisher.packageName.replaceAll("\\.", "/"),
                fileName: model.eventPublisher.className + ".groovy"
        )
    }

    static generateValidatorInterface(String baseDirectory, model) {
        toFile(
                templateReader: "/templates/entity/validator.template",
                model: model,
                directory: baseDirectory + "/domain/src/main/groovy/" + model.validator.packageName.replaceAll("\\.", "/"),
                fileName: model.validator.className + ".groovy"
        )
    }

    static generateValidationException(String baseDirectory, model) {
        toFile(
                templateReader: "/templates/entity/validationException.template",
                model: model,
                directory: baseDirectory + "/domain/src/main/groovy/" + model.entity.packageName.replaceAll("\\.", "/"),
                fileName: model.entity.className + "ValidationException.groovy"
        )
    }

    static generateJsr303Validator(String baseDirectory, model) {
        toFile(
                templateReader: "/templates/entity/jsr303Validator.template",
                model: model,
                directory: baseDirectory + "/webapp/src/main/groovy/" + model.jsr303Validator.packageName.replaceAll("\\.", "/"),
                fileName: model.jsr303Validator.className + ".groovy"
        )
    }

    static generateDomainServiceInterface(String baseDirectory, model) {
        toFile(
                templateReader: "/templates/entity/domainServiceInterface.template",
                model: model,
                directory: baseDirectory + "/domain/src/main/groovy/" + model.domainService.packageName.replaceAll("\\.", "/"),
                fileName: model.domainService.className + ".groovy"
        )
    }

    static generateDomainServiceImplementation(String baseDirectory, model) {

        toFile(
                templateReader: "/templates/entity/domainServiceImplementation.template",
                model: model,
                directory: baseDirectory + "/domain/src/main/groovy/" + model.domainService.packageName.replaceAll("\\.", "/"),
                fileName: model.domainService.className + "Impl.groovy"
        )
    }

    static generateApplicationServiceInterface(String baseDirectory, model) {
        toFile(
                templateReader: "/templates/entity/applicationServiceInterface.template",
                model: model,
                directory: baseDirectory + "/webapp/src/main/groovy/" + model.applicationService.packageName.replaceAll("\\.", "/"),
                fileName: model.applicationService.className + ".groovy"
        )
    }

    static generateApplicationServiceImplementation(String baseDirectory, model) {
        toFile(
                templateReader: "/templates/webapp/applicationServiceImplementation.template",
                model: model,
                directory: baseDirectory + "/domain/src/main/groovy/" + model.applicationService.packageName.replaceAll("\\.", "/"),
                fileName: model.applicationService.className + "Impl.groovy"
        )
    }

    static generateResourceController(String baseDirectory, model) {
        toFile(
                templateReader: "/templates/webapp/resourceController.template",
                model: model,
                directory: baseDirectory + "/domain/src/main/groovy/" + model.resourceController.packageName.replaceAll("\\.", "/"),
                fileName: model.resourceController.className + ".groovy"
        )
    }
}
