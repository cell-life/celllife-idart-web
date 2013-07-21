package org.celllife.idart.codegen

class CodeableSpringDataRepositoryGenerator {

    static generateCodeableSpringDataRepository(String baseDirectory, model) {

        Output.toFile(
                templateReader: "/templates/codeable/springDataRepository.template",
                model: model,
                directory: baseDirectory + "/" + model.springDataPackageName.replaceAll("\\.", "/"),
                fileName: "SpringData" + model.entityName + "Repository.java"
        )
    }
}