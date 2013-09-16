package org.celllife.idart.codegen.entity

import static org.celllife.idart.codegen.FileWriter.toFile
import static org.celllife.idart.codegen.StdOutWriter.toStdOut
import static org.celllife.idart.codegen.entity.EntityModelTransform.transform

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 20h41
 */
class EntityCodeGenerator {

    static generateEntityCode(String baseDirectory, String baseNamespace, model) {

        transform(baseNamespace, model)

        model.features.includes.each { feature ->

            switch (feature) {
                case "id":
                    generateId(baseDirectory, model)
                    break
                case "entity":
                    generateEntity(baseDirectory, model)
                    break
                case "domainService":
                    generateDomainServiceInterface(baseDirectory, model)
                    generateDomainServiceImplementation(baseDirectory, model)
                    break
                case "repository":
                    generateRepository(baseDirectory, model)
                    generateEntityNotFoundException(baseDirectory, model)
                    break
                case "springDataRepository":
                    generateSpringDataRepository(baseDirectory, model)
                    break
                case "domainEvent":
                    generateDomainEvent(baseDirectory, model)
                    break
                case "eventPublisher":
                    generateEventPublisher(baseDirectory, model)
                    break
                case "camelEventPublisher":
                    generateCamelEventPublisher(baseDirectory, model)
                    break
                case "validator":
                    generateValidatorInterface(baseDirectory, model)
                    generateValidationException(baseDirectory, model)
                    break
                case "jsr303Validator":
                    generateJsr303Validator(baseDirectory, model)
                    break
                case "applicationService":
                    generateDto(baseDirectory, model)
                    generateDtoAssembler(baseDirectory, model)
                    generateApplicationServiceInterface(baseDirectory, model)
                    generateApplicationServiceImplementation(baseDirectory, model)
                    break
                case "securityAdapter":
                    generateSecurityAdapter(baseDirectory, model)
                    break
                case "resourceController":
                    generateResourceController(baseDirectory, model)
                    break
                case "": break
            }

        }
    }

    static generateId(String baseDirectory, model) {
        toFile(
                templateReader: "/templates/entity/id.template",
                model: model,
                directory: baseDirectory + "/common/src/main/java/" + model.id.packageName.replaceAll("\\.", "/"),
                fileName: model.id.className + ".java"
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

    static generateDomainEvent(String baseDirectory, model) {
        toStdOut(
                templateReader: "/templates/entity/domainEventCamelContext.template",
                model: model
        )
        toFile(
                templateReader: "/templates/entity/domainEvent.template",
                model: model,
                directory: baseDirectory + "/domain/src/main/groovy/" + model.domainEvent.packageName.replaceAll("\\.", "/"),
                fileName: model.domainEvent.className + ".groovy"
        )
    }

    static generateEventPublisher(String baseDirectory, model) {
        toFile(
                templateReader: "/templates/entity/eventPublisher.template",
                model: model,
                directory: baseDirectory + "/domain/src/main/groovy/" + model.eventPublisher.packageName.replaceAll("\\.", "/"),
                fileName: model.eventPublisher.className + ".groovy"
        )
    }

    static generateCamelEventPublisher(String baseDirectory, model) {
        toFile(
                templateReader: "/templates/entity/camelEventPublisher.template",
                model: model,
                directory: baseDirectory + "/webapp/src/main/groovy/" + model.camelEventPublisher.packageName.replaceAll("\\.", "/"),
                fileName: model.camelEventPublisher.className + ".groovy"
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

    static generateDto(String baseDirectory, model) {
        toFile(
                templateReader: "/templates/entity/dto.template",
                model: model,
                directory: baseDirectory + "/webapp/src/main/groovy/" + model.dto.packageName.replaceAll("\\.", "/"),
                fileName: model.dto.className + ".groovy"
        )
    }

    static generateDtoAssembler(String baseDirectory, model) {
        toFile(
                templateReader: "/templates/entity/dtoAssembler.template",
                model: model,
                directory: baseDirectory + "/webapp/src/main/groovy/" + model.dtoAssembler.packageName.replaceAll("\\.", "/"),
                fileName: model.dtoAssembler.className + ".groovy"
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
                templateReader: "/templates/entity/applicationServiceImplementation.template",
                model: model,
                directory: baseDirectory + "/webapp/src/main/groovy/" + model.applicationService.packageName.replaceAll("\\.", "/"),
                fileName: model.applicationService.className + "Impl.groovy"
        )
    }

    static generateSecurityAdapter(String baseDirectory, model) {
        toFile(
                templateReader: "/templates/entity/securityAdapter.template",
                model: model,
                directory: baseDirectory + "/webapp/src/main/groovy/" + model.securityAdapter.packageName.replaceAll("\\.", "/"),
                fileName: model.securityAdapter.className + ".groovy"
        )
    }

    static generateResourceController(String baseDirectory, model) {
        toFile(
                templateReader: "/templates/entity/resourceController.template",
                model: model,
                directory: baseDirectory + "/webapp/src/main/groovy/" + model.resourceController.packageName.replaceAll("\\.", "/"),
                fileName: model.resourceController.className + ".groovy"
        )
    }
}
