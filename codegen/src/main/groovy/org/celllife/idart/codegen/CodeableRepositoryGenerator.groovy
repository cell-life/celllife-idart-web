package org.celllife.idart.codegen

class CodeableRepositoryGenerator {

    static generateCodeableRepository(String baseDirectory, model) {

        def directory = baseDirectory + "/" + model.domainPackageName.replaceAll("\\.", "/")
        def fileName = model.entityName + "Repository.java"

        Output.toFile(
                templateReader: "/templates/codeableRepository.template",
                model: model,
                directory: directory,
                fileName: fileName
        )
    }
}