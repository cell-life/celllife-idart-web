package org.celllife.idart.codegen

class CodeableDomainServiceGenerator {

    static generateCodeableDomainService(String groovySourcesDirectory, model) {
        generateCodeableDomainServiceInterface(groovySourcesDirectory, model)
        generateCodeableDomainServiceImplementation(groovySourcesDirectory, model)
    }

    static generateCodeableDomainServiceInterface(String baseDirectory, model) {

        def directory = baseDirectory + "/" + model.domainPackageName.replaceAll("\\.", "/")
        def fileName = model.entityName + "Service.groovy"

        Output.toFile(
                templateReader: "/templates/codeableDomainServiceInterface.template",
                model: model,
                directory: directory,
                fileName: fileName
        )
    }

    static generateCodeableDomainServiceImplementation(String baseDirectory, model) {

        def directory = baseDirectory + "/" + model.domainPackageName.replaceAll("\\.", "/")
        def fileName = model.entityName + "ServiceImpl.groovy"

        Output.toFile(
                templateReader: "/templates/codeableDomainServiceImplementation.template",
                model: model,
                directory: directory,
                fileName: fileName
        )
    }

}