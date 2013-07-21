package org.celllife.idart.codegen

class IdentifiableDomainServiceGenerator {

    static generateIdentifiableDomainService(String groovySourcesDirectory, String generatedSourcesDirectory, model) {
        generateIdentifiableDomainServiceInterface(generatedSourcesDirectory, model)
        generateIdentifiableDomainServiceImplementation(groovySourcesDirectory, model)
    }

    static generateIdentifiableDomainServiceInterface(String baseDirectory, model) {

        def directory = baseDirectory + "/" + model.domainPackageName.replaceAll("\\.", "/")
        def fileName = model.entityName + "Service.java"

        Output.toFile(
                templateReader: "/templates/identifiableDomainServiceInterface.template",
                model: model,
                directory: directory,
                fileName: fileName
        )
    }

    static generateIdentifiableDomainServiceImplementation(String baseDirectory, model) {

        def directory = baseDirectory + "/" + model.domainPackageName.replaceAll("\\.", "/")
        def fileName = model.entityName + "ServiceImpl.groovy"

        Output.toFile(
                templateReader: "/templates/identifiableDomainServiceImplementation.template",
                model: model,
                directory: directory,
                fileName: fileName
        )
    }

}