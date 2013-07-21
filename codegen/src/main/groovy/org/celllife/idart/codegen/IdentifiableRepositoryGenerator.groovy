package org.celllife.idart.codegen

class IdentifiableRepositoryGenerator {

    static generateIdentifiableRepository(String baseDirectory, model) {

        def directory = baseDirectory + "/" + model.domainPackageName.replaceAll("\\.", "/")
        def fileName = model.entityName + "Repository.groovy"

        Output.toFile(
                templateReader: "/templates/identifiableRepository.template",
                model: model,
                directory: directory,
                fileName: fileName
        )
    }
}