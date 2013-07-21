package org.celllife.idart.codegen

class CodeableSpringDataRepositoryGenerator {

    static generateCodeableSpringDataRepository(String baseDirectory, model) {

        def directory = baseDirectory + "/" + model.springDataPackageName.replaceAll("\\.", "/")
        def fileName = "SpringData" + model.entityName + "Repository.java"

        Output.toFile(
                templateReader: "/templates/codeableSpringDataRepository.template",
                model: model,
                directory: directory,
                fileName: fileName
        )
    }
}