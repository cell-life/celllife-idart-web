package org.celllife.idart.codegen

class IdentifiableSpringDataRepositoryGenerator {

    static generateIdentifiableSpringDataRepository(String baseDirectory, model) {

        def directory = baseDirectory + "/" + model.springDataPackageName.replaceAll("\\.", "/")
        def fileName = "SpringData" + model.entityName + "Repository.java"

        Output.toFile(
                templateReader: "/templates/identifiableSpringDataRepository.template",
                model: model,
                directory: directory,
                fileName: fileName
        )
    }
}